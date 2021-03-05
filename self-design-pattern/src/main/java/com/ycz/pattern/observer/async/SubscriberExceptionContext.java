package com.ycz.pattern.observer.async;

import java.lang.reflect.Method;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 订阅者引发的异常的上下文
 */
public class SubscriberExceptionContext {
    /**
     * 事件总线
     */
    private final EventBus eventBus;
    /**
     * 事件
     */
    private final Object event;
    /**
     * 订阅者
     */
    private final Object subscriber;
    /**
     * 订阅方法
     */
    private final Method subscriberMethod;

    public SubscriberExceptionContext(EventBus eventBus, Object event, Object subscriber, Method subscriberMethod) {
        this.eventBus = checkNotNull(eventBus);
        this.event = checkNotNull(event);
        this.subscriber = checkNotNull(subscriber);
        this.subscriberMethod = checkNotNull(subscriberMethod);
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public Object getEvent() {
        return event;
    }

    public Object getSubscriber() {
        return subscriber;
    }

    public Method getSubscriberMethod() {
        return subscriberMethod;
    }
}
