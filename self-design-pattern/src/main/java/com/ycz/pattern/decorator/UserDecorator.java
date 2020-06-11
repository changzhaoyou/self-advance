package com.ycz.pattern.decorator;

/**
 * 抽象装饰类（Decorator类）
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/17 23:32
 * @desc
 */
public abstract class UserDecorator extends UserService {
    //装饰器的核心
    private UserService userService;

    public UserDecorator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void login(String userName) {
        userService.login(userName);
    }
}
