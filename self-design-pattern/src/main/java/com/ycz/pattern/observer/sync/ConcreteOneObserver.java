package com.ycz.pattern.observer.sync;

/**
 * @author zhangzhaoyou
 * 具体观察者
 */
public class ConcreteOneObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("收到通知更新,ConcreteOneObserver:" + message);
    }
}
