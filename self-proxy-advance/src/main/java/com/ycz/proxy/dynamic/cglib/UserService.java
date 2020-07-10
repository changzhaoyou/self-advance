package com.ycz.proxy.dynamic.cglib;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc Cglib动态代理-被代理对象
 */
public interface UserService {
    /**
     * 请求方法
     *
     * @param name
     */
    void sayHello(String name);

    /**
     * 请求方法
     * @param name
     */
    void sayThanks(String name);
}
