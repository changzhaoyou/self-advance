package com.ycz.pattern.observer.async;

/**
 * 订阅者处理引发的异常
 */
public interface SubscriberExceptionHandler {
    /**
     * 处理异常
     * @param exception 异常
     * @param subscriberExceptionContext 订阅者异常上下文
     */
    void handleException(Throwable exception,SubscriberExceptionContext subscriberExceptionContext);
}
