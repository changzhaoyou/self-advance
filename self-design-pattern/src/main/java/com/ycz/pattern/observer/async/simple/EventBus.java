package com.ycz.pattern.observer.async.simple;

import com.ycz.pattern.observer.async.ObserverExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author zhangzhaoyou
 */
public class EventBus {

    private Executor executor;

    private SubscriberRegistry registry = new SubscriberRegistry();

    public EventBus() {
        this.executor = ObserverExecutors.directExecutor();
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    /**
     * 注册订阅
     *
     * @param listener 订阅者
     */
    public void register(Object listener) {
        registry.register(listener);
    }

    /**
     * 取消订阅
     *
     * @param listener 订阅者
     */
    public void unregister(Object listener) {
        registry.unregister(listener);
    }

    /**
     * 事件通知
     *
     * @param event 消息或者事件通知实体
     */
    public void post(Object event) {
        List<Subscriber> subscribers = registry.getSubscribers(event);
        for (Subscriber subscriber : subscribers) {
            executor.execute(() -> {
                subscriber.execute(event);
            });
        }
    }
}
