package com.ycz.pattern.factory.simple;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct(2);
        product.operate();
    }
}
