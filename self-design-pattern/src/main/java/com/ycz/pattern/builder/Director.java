package com.ycz.pattern.builder;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/5/8 11:00
 * @desc 指挥者
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product createProduct() {
        builder.buildColour();
        //钩子
        if (builder.isBuildHair()) {
            builder.buildHair();
        }
        return builder.getProduct();
    }
}
