package com.ycz.pattern.proxy.compose;

/**
 * 客户端类
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 23:32
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        UserService userProxy=new UserProxy(userService);
        userProxy.login("张三");
    }
}
