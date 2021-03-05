package com.ycz.pattern.observer.async.simple;

import java.util.concurrent.Executor;

/**
 * @author zhangzhaoyou
 * 异步事件
 */
public class AsyncEventBus extends EventBus{

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
