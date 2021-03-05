package com.ycz.pattern.mediate;

/**
 * Created by ycz on  2021/02/26/5:56 下午
 */
public class ColleagueA extends Colleague{

    @Override
    void send() {
        System.out.println("同事A发送消息....");
        mediator.relay(this);
    }

    @Override
    void receive() {
        System.out.println("同事A收到请求....");
    }
}
