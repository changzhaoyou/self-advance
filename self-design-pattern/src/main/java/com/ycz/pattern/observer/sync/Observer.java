package com.ycz.pattern.observer.sync;

/**
 * @author zhangzhaoyou
 * 观察者
 */
interface Observer {
    /**
     * 通知观察者
     * @param message 通知消息
     */
    void update(String message);
}
