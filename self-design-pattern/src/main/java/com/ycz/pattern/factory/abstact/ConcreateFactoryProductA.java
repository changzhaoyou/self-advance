package com.ycz.pattern.factory.abstact;

/**
 * 创建产品A
 */
public class ConcreateFactoryProductA extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
