package com.ycz.proxy.dynamic.jdk;

/**
 * JDK动态代理-实现(目标类)
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:04
 * @desc
 */
public class HelloServiceImpl implements HelloService {

    public void sayHello(String name) {
        System.out.println(name + ",hello world!");
    }
}
