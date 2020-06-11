package com.ycz.pattern.decorator;

/**
 * 客户端类--测试类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/17 23:43
 * @desc
 */
public class DecoratorTest {

    public static void main(String[] args) {
        //第一种方式
        UserService userService = new UserServiceImpl();
        UserDecorator userDecorator = new UserLogRecordDecorator(userService);
        userDecorator.login("张三");
        //第二种方式
        UserService  userService1=new UserLogRecordDecorator(new UserServiceImpl());
        userService1.login("李四");

    }
}
