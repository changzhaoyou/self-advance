package com.ycz.pattern.factory.abstact;

public class Cilent {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreateFactoryProductA();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
        productA.show();
        productB.show();
    }
}
