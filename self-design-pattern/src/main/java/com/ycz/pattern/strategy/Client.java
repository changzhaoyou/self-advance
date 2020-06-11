package com.ycz.pattern.strategy;

/**
 * 测试类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 14:41
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        Strategy strategy=new ConcreteStrategyA();
        Context context=new Context(strategy);
        context.algorithm();
    }
}
