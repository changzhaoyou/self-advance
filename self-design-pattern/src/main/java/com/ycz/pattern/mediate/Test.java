package com.ycz.pattern.mediate;

/**
 * Created by ycz on  2021/02/26/11:26 下午
 */
public class Test {

    public static void main(String[] args) {
        Mediator mediator=new ConcreteMediator();
        Colleague colleagueA=new ColleagueA();
        Colleague colleagueB=new ColleagueB();
        mediator.register(colleagueA);
        mediator.register(colleagueB);
        colleagueA.send();
        colleagueB.send();
    }
}
