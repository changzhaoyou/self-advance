package com.ycz.pattern.proxy.inherit;

/**
 * RealSubject(真实主题角色)
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 23:28
 * @desc
 */
public class UserServiceImpl implements UserService {
    @Override
    public void login(String name) {
        System.out.println("用户：" + name + "，登录成功");
    }
}
