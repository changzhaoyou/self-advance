package com.ycz.proxy.dynamic.jdk;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc JDK动态代理-接口
 */
public interface HelloService {
    /**
     * 请求方法
     *
     * @param name
     */
    void sayHello(String name);
}
