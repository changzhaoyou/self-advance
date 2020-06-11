package com.ycz.pattern.factory.method;

/**
 * 具体B产品抽象工厂类
 */
public class ConcreateFactoryB extends AbstractFactory {


    @Override
    <T extends Product> T createProduct(Class<T> tClass) {
        try {
            return (T) Class.forName(tClass.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    Product createProduct() {
        return new ConcreateProductB();
    }
}
