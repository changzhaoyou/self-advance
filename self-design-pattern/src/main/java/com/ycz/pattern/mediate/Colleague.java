package com.ycz.pattern.mediate;

/**
 * Created by ycz on  2021/02/26/5:50 下午
 * 抽象同事类（Colleague）角色
 */
abstract class Colleague {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    abstract void send();

    abstract void receive();
}
