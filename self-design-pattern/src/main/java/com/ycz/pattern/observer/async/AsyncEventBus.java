package com.ycz.pattern.observer.async;

import java.util.concurrent.Executor;

/**
 * 异步事件通知
 */
public class AsyncEventBus extends EventBus{
    /**
     * 构造有标识符和执行器方法
     * @param identifier 标识符
     * @param executor 执行器
     */
    public AsyncEventBus(String identifier, Executor executor){
        super(identifier, executor, Dispatcher.legacyAsync(), LoggingHandler.INSTANCE);
    }

    /**
     * 构造默认标识符和执行器异步方法
     * @param executor
     */
    public AsyncEventBus(Executor executor) {
        super("default", executor, Dispatcher.legacyAsync(), LoggingHandler.INSTANCE);
    }

    /**
     * 构造默认标识符、执行器和订阅者异常处理异常方法
     * @param executor
     * @param subscriberExceptionHandler
     */
    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super("default", executor, Dispatcher.legacyAsync(), subscriberExceptionHandler);
    }
}
