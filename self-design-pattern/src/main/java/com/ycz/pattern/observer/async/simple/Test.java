package com.ycz.pattern.observer.async.simple;

/**
 * @author zhangzhaoyou
 * 测试类
 */
public class Test {

    public static void main(String[] args) {
        EventBus eventBus=new EventBus();
        TokenListener tokenListener = new TokenListener();
        eventBus.register(tokenListener);
        eventBus.unregister(tokenListener);
        eventBus.post("事件通知");
        eventBus.post(new Message("监听通知","default"));
    }

}
