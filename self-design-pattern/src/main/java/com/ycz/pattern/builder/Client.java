package com.ycz.pattern.builder;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/5/8 11:20
 * @desc 测试客户端
 */
public class Client {

    public static void main(String[] args) {
        //是否构建头发 false/true
        Builder builder = new WhiteBuilder(false);
        Director director = new Director(builder);
        Product product = director.createProduct();
        System.out.println(product);
        Builder builder1 = new BlackBuilder();
        Director director1 = new Director(builder1);
        Product product1= director1.createProduct();
        System.out.println(product1);
    }
}
