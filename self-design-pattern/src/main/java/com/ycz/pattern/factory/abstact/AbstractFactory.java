package com.ycz.pattern.factory.abstact;

/**
 * 抽象工厂方法
 */
public abstract class AbstractFactory {
    /**
     * 抽象产品A
     *
     * @return
     */
    public abstract AbstractProductA createProductA();

    /**
     * 抽象产品B
     *
     * @return
     */
    public abstract AbstractProductB createProductB();
}
