package com.ycz.pattern.observer.async;

import com.google.common.eventbus.AllowConcurrentEvents;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author zhangzhaoyou
 * 订阅特定方法，分发执行程序事件
 */
public class Subscriber {
    /**
     * 事件订阅者总线
     */
    private EventBus eventBus;
    /**
     * 订阅者对象
     */
    final Object target;
    /**
     * 订阅者方法
     */
    private final Method method;
    /**
     * 调度事件订阅者
     */
    private final Executor executor;

    static Subscriber create(EventBus eventBus, Object listener, Method method) {
        return isDeclaredThreadSafe(method) ? new Subscriber(eventBus, listener, method) : new SynchronizedSubscriber(eventBus, listener, method);
    }

    /**
     * 判断是否有AllowConcurrentEvents注解，线程是否安全，开启并发执行还是串行
     *
     * @param method 事件订阅者方法
     * @return
     */
    private static boolean isDeclaredThreadSafe(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    public Subscriber(EventBus eventBus, Object target, Method method) {
        this.eventBus = eventBus;
        this.target = checkNotNull(target);
        this.method = method;
        method.setAccessible(true);
        this.executor = eventBus.getExecutor();
    }

    /**
     * 分发事件
     *
     * @param event
     */
    final void dispatchEvent(final Object event) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    invokeSubscriberMethod(event);
                } catch (InvocationTargetException e) {
                    eventBus.handleSubscriberException(e, context(event));
                }
            }
        });
    }

    /**
     * 重写调用订阅者对象方法
     *
     * @param event 事件对象
     */
    void invokeSubscriberMethod(Object event) throws InvocationTargetException {
        try {
            method.invoke(target, checkNotNull(event));
        } catch (IllegalArgumentException e) {
            throw new Error("Method rejected target/argument: " + event, e);
        } catch (IllegalAccessException e) {
            throw new Error("Method became inaccessible: " + event, e);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof Error) {
                throw (Error) e.getCause();
            }
            throw e;
        }
    }

    /**
     * 获取订阅者的上下文
     *
     * @param event
     * @return
     */
    private SubscriberExceptionContext context(Object event) {
        return new SubscriberExceptionContext(eventBus, event, target, method);
    }

    @Override
    public int hashCode() {
        return (31 + method.hashCode()) * 31 + System.identityHashCode(method);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Subscriber) {
            Subscriber that = (Subscriber) obj;
            return target == that.target && method.equals(that.method);
        }
        return false;
    }

    /**
     * 同步方法调用订阅者方法，保证线程安全
     */
    private static class SynchronizedSubscriber extends Subscriber {
        public SynchronizedSubscriber(EventBus eventBus, Object listener, Method method) {
            super(eventBus, listener, method);
        }

        @Override
        void invokeSubscriberMethod(Object event) throws InvocationTargetException {
            //线程安全处理
            synchronized (this){
                super.invokeSubscriberMethod(event);
            }
        }
    }
}
