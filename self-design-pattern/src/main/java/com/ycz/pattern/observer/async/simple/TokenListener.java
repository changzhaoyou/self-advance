package com.ycz.pattern.observer.async.simple;

/**
 * 订阅者
 */
public class TokenListener {

    @Subscribe
    public void notifyMsg(String message){
        System.out.println("notifyMsg:"+message);
    }

    @Subscribe
    public void notifyObject(Message message){
        System.out.println("notifyObject:"+message);
    }
}
