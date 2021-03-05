package com.ycz.pattern.observer.async;

import com.google.common.annotations.Beta;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 事件通知发送器
 */
@Beta
public class EventBus {

    private Logger log = Logger.getLogger(EventBus.class.getName());

    /**
     * 标识符
     */
    private final String identifier;
    /**
     * 线程
     */
    private final Executor executor;
    /**
     * 订阅者执行异常处理
     */
    private final SubscriberExceptionHandler exceptionHandler;
    /**
     * 订阅者事件注册
     */
    private final SubscriberRegistry subscribers = new SubscriberRegistry(this);

    private final Dispatcher dispatcher;

    EventBus(
            String identifier,
            Executor executor,
            Dispatcher dispatcher,
            SubscriberExceptionHandler exceptionHandler) {
        this.identifier = checkNotNull(identifier);
        this.executor = checkNotNull(executor);
        this.dispatcher = checkNotNull(dispatcher);
        this.exceptionHandler = checkNotNull(exceptionHandler);
    }

    public EventBus() {
        this("default");
    }

    public EventBus(String identifier) {
        this(identifier,
                ObserverExecutors.directExecutor(),
                Dispatcher.perThreadDispatchQueue(),
                LoggingHandler.INSTANCE);
    }

    public EventBus(SubscriberExceptionHandler exceptionHandler) {
        this(
                "default",
                ObserverExecutors.directExecutor(),
                Dispatcher.perThreadDispatchQueue(),
                exceptionHandler);
    }

    public final Executor getExecutor() {
        return executor;
    }

    public final String identifier() {
        return identifier;
    }

    /**
     * 注册订阅者
     * @param object 订阅者对象
     */
    public void register(Object object) {
        subscribers.register(object);
    }

    /**
     * 取消订阅者
     * @param object 订阅者
     */
    public void unregister(Object object) {
        subscribers.unregister(object);
    }

    /**
     * 事件通知
     * @param event 事件
     */
    public void post(Object event) {
        Iterator<Subscriber> eventSubscribers = subscribers.getSubscribers(event);
        if (eventSubscribers.hasNext()) {
            dispatcher.dispatch(event, eventSubscribers);
        } else if (!(event instanceof DeadEvent)) {
            post(new DeadEvent(this, event));
        }
    }

    /**
     * 处理订阅者异常
     *
     * @param e       异常信息
     * @param context 异常上下文
     */
    void handleSubscriberException(Throwable e, SubscriberExceptionContext context) {
        checkNotNull(e);
        checkNotNull(context);
        try {
            exceptionHandler.handleException(e, context);
        } catch (Throwable e2) {
            // if the handler threw an exception... well, just log it
            log.log(
                    Level.SEVERE,
                    String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", e2, e),
                    e2);
        }
    }

    /**
     * 简单记录订阅者处理异常
     */
    static final class LoggingHandler implements SubscriberExceptionHandler {
        static final LoggingHandler INSTANCE = new LoggingHandler();

        private static Logger logger(SubscriberExceptionContext context) {
            return Logger.getLogger(EventBus.class.getName() + "." + context.getEventBus().identifier());
        }

        /**
         * 异常信息
         * @param context 异常上下文信息
         * @return
         */
        private static String message(SubscriberExceptionContext context) {
            Method method = context.getSubscriberMethod();
            return "Exception thrown by subscriber method "
                    + method.getName()
                    + '('
                    + method.getParameterTypes()[0].getName()
                    + ')'
                    + " on subscriber "
                    + context.getSubscriber()
                    + " when dispatching event: "
                    + context.getEvent();
        }

        @Override
        public void handleException(Throwable exception, SubscriberExceptionContext context) {
            Logger logger = logger(context);
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, message(context), exception);
            }
        }
    }
}
