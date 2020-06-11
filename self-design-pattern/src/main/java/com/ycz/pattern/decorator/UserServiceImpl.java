package com.ycz.pattern.decorator;

/**
 * 具体构件类子类(ConcreteComponent)
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/17 23:30
 * @desc
 */
public class UserServiceImpl extends UserService {
    @Override
    public void login(String userName) {
        System.out.println("用户:" + userName + "，登录成功");
    }
}
