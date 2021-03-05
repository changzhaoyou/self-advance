package com.ycz.pattern.observer.sync;

/**
 * @author zhangzhaoyou
 * 目标类
 */
interface Subject {
    /**
     * 注册观察者
     * @param observer 观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     * @param message 消息通知内容
     */
    void notifyObservers(String message);
}
