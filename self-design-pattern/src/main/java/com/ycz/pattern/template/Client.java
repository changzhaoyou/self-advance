package com.ycz.pattern.template;

/**
 * 测试类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 16:38
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        ordinaryLogin();
        superLogin();
    }

    private static void ordinaryLogin() {
        User ordinary = new User();
        ordinary.setId(1);
        ordinary.setName("ordinary");
        ordinary.setPassword("123456");
        LoginTemplate loginTemplate = new OrdinaryUser();
        boolean isLogin = loginTemplate.login(ordinary);
        System.out.println("登录是否成功：" + isLogin);
    }

    private static void superLogin() {
        User ordinary = new User();
        ordinary.setId(1);
        ordinary.setName("admin");
        ordinary.setPassword("123456");
        LoginTemplate loginTemplate = new SuperUser();
        boolean isLogin = loginTemplate.login(ordinary);
        System.out.println("登录是否成功：" + isLogin);
    }
}
