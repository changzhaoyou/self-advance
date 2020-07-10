package com.ycz.proxy.dynamic.jdk;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:04
 * @desc JDK动态代理-实现(目标类)
 */
public class HelloServiceImpl implements HelloService {


    @Override
    public void sayHello(String name) {
        System.out.println(name + ",hello world!");
    }
}
