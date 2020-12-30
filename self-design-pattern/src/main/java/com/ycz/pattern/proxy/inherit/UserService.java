package com.ycz.pattern.proxy.inherit;

/**
 * Subject(抽象主题角色)
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 23:21
 * @desc
 */
public interface UserService {
    /**
     * 实现登录方法
     *
     * @param name
     */
    void login(String name);
}
