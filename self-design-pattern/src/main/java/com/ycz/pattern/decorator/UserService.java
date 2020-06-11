package com.ycz.pattern.decorator;

/**
 * 抽象构件类（Component的角色）
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/17 23:28
 * @desc
 */
public abstract class UserService {
    /**
     * 登录系统
     * @param userName
     */
    public abstract void login(String userName);
}
