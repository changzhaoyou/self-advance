package com.ycz.proxy.dynamic.cglib;
/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc Cglib动态代理-目标代理类
 */
public class UserServiceImpl implements UserService{
    @Override
    public void sayHello(String name) {
        System.out.println("sayHello:"+name);
    }

    @Override
    public void sayThanks(String name) {
        System.out.println("sayThanks:"+name);
    }
}
