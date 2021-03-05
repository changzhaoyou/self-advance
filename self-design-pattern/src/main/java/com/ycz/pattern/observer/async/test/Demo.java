package com.ycz.pattern.observer.async.test;

import com.ycz.pattern.observer.async.AsyncEventBus;
import com.ycz.pattern.observer.async.EventBus;

import java.util.concurrent.*;

/**
 * 测试
 */
public class Demo {
    public static void main(String[] args) {
        testSync();
        //testAsync();
    }

    private static void testAsync() {
        EventBus asyncEventBus = new AsyncEventBus(Executors.newSingleThreadExecutor());
        asyncEventBus.register(new LoggingListener());
        asyncEventBus.post(new LogEvent("日志记录"));
    }

    private static void testSync() {
        EventBus eventBus = new EventBus();
        LoggingListener loggingListener = new LoggingListener();
        eventBus.register(loggingListener);
        eventBus.unregister(loggingListener);
        eventBus.register(new NoSubscriberListener());
        eventBus.post("String类型");
        eventBus.post(new LogEvent("日志记录"));
    }
}
