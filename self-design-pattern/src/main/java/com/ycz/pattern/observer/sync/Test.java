package com.ycz.pattern.observer.sync;

/**
 * @author zhangzhaoyou
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Subject subject=new ConcreteSubject();
        subject.registerObserver(new ConcreteOneObserver());
        ConcreteTwoObserver concreteTwoObserver = new ConcreteTwoObserver();
        subject.registerObserver(concreteTwoObserver);
        subject.notifyObservers("事件通知1");
        subject.removeObserver(concreteTwoObserver);
        subject.notifyObservers("事件通知2");
    }
}
