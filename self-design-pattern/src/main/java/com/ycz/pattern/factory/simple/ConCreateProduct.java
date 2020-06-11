package com.ycz.pattern.factory.simple;

/**
 * 具体产品类
 */
public class ConCreateProduct extends Product {

    @Override
    void operate() {
        System.out.println("ConCreateProduct Instance  Success");
    }
}
