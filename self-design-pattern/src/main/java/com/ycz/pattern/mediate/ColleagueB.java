package com.ycz.pattern.mediate;

/**
 * Created by ycz on  2021/02/26/11:22 下午
 */
public class ColleagueB extends Colleague{

    @Override
    void send() {
        System.out.println("同事B发送消息.....");
        mediator.relay(this);
    }

    @Override
    void receive() {
        System.out.println("同事B收到请求.....");
    }
}
