package com.ycz.pattern.mediate;

/**
 * Created by ycz on  2021/02/26/5:41 下午
 * 抽象中介者（Mediator）角色
 */
interface  Mediator {

     void register(Colleague colleague);

     void relay(Colleague colleague);
}
