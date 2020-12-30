package com.ycz.pattern.proxy.inherit;

/**
 * DynamicProxy(代理主题对象)
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 23:29
 * @desc
 */
public class UserProxy extends UserServiceImpl {

    @Override
    public void login(String name) {
        System.out.println("开始调用代理对象");
        super.login(name);
        System.out.println("调用代理对象结束");
    }
}
