package com.ycz.pattern.observer.async;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author zhangzhaoyou
 * 事件分发器
 * 用于将事件分发给订阅者的处理程序，提供不同的事件排序保证适用于不同情况
 */
abstract class Dispatcher {

    static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }

    public static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    public abstract void dispatch(Object event, Iterator<Subscriber> eventSubscribers);

    /**
     *
     */
    static final class PerThreadQueuedDispatcher extends Dispatcher {
        /**
         * 定义线程队列
         */
        private final ThreadLocal<Queue<Event>> queue = new ThreadLocal<Queue<Event>>() {
            @Override
            protected Queue<Event> initialValue() {
                return new ArrayDeque<>();
            }
        };
        /**
         * 每个线程状态，避免重复事件调度
         */
        private final ThreadLocal<Boolean> dispatching = new ThreadLocal<Boolean>() {
            @Override
            protected Boolean initialValue() {
                return Boolean.FALSE;
            }
        };

        @Override
        public void dispatch(Object event, Iterator<Subscriber> subscribers) {
            checkNotNull(event);
            checkNotNull(subscribers);
            Queue<Event> eventQueue = queue.get();
            eventQueue.offer(new Event(event, subscribers));
            if (!dispatching.get()) {
                dispatching.set(Boolean.TRUE);
                try {
                    Event nextEvent;
                    while ((nextEvent = eventQueue.poll()) != null) {
                        while (subscribers.hasNext()) {
                            nextEvent.subscribers.next().dispatchEvent(nextEvent.event);
                        }
                    }
                } finally {
                    dispatching.remove();
                    queue.remove();
                }
            }
        }

        private static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            private Event(Object event, Iterator<Subscriber> subscribers) {
                this.event = event;
                this.subscribers = subscribers;
            }
        }
    }

    /**
     * 分发到全局队列上
     */
    static final class LegacyAsyncDispatcher extends Dispatcher {

        private final ConcurrentLinkedDeque<EventWithSubscriber> queue = new ConcurrentLinkedDeque<>();

        @Override
        public void dispatch(Object event, Iterator<Subscriber> eventSubscribers) {
            checkNotNull(event);
            while (eventSubscribers.hasNext()) {
                queue.add(new EventWithSubscriber(event, eventSubscribers.next()));
            }
            EventWithSubscriber e;
            while ((e = queue.poll()) != null) {
                e.subscriber.dispatchEvent(event);
            }
        }


        private static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            public EventWithSubscriber(Object event, Subscriber subscriber) {
                this.event = event;
                this.subscriber = subscriber;
            }
        }
    }

    /**
     * 分发器不经过队列，直接调用订阅者通知
     */
    static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        @Override
        public void dispatch(Object event, Iterator<Subscriber> subscribers) {
            checkNotNull(event);
            while (subscribers.hasNext()) {
                subscribers.next().dispatchEvent(event);
            }
        }
    }
}
