package com.ycz.pattern.bridge;

/**
 * 测试桥接类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/16 17:24
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImpl();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.operation();
    }
}
