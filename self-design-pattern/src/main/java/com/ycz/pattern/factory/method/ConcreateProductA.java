package com.ycz.pattern.factory.method;

/**
 * 具体产品A实现
 */
public class ConcreateProductA extends Product {
    @Override
    void show() {
        System.out.println("show A product.....");
    }
}
