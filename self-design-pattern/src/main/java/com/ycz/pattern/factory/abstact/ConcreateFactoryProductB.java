package com.ycz.pattern.factory.abstact;

/**
 * 创建产品B
 */
public class ConcreateFactoryProductB extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
