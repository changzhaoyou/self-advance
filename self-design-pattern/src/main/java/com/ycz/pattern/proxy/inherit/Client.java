package com.ycz.pattern.proxy.inherit;

/**
 * 客户端类
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 23:32
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        UserService userProxy=new UserProxy();
        userProxy.login("张三");
    }
}
