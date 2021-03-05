package com.ycz.pattern.observer.async.test;

public class NoSubscriberListener {

    public void listen(String message){
        System.out.println("没有表示订阅Subscriber注解："+message);
    }
}
