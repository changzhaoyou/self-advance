package com.ycz.pattern.template.callback;

import com.ycz.pattern.template.User;

/**
 * 回调函数
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 16:55
 * @desc
 */
public interface LoginCallback {
    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    User findUser(User user);

    /**
     * 匹配用户账号密码
     *
     * @param user
     * @return
     */
    boolean match(User user);
}
