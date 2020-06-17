package com.ycz.proxy.dynamic.cglib;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc Cglib动态代理-被代理对象
 */
public class HelloService {
    /**
     * 请求方法
     *
     * @param name
     */
    void sayHello(String name) {
        System.out.println("name:" + name + ",hello world!!!");
    }

    /**
     * 请求方法
     *
     * @param name
     */
    void sayThanks(String name) {
        System.out.println("name:" + name + ",Thank you !!!");
    }
}
