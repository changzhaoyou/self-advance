package com.ycz.pattern.template.callback;

import com.ycz.pattern.template.User;

/**
 * 登录模板方法
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 16:13
 * @desc
 */
class LoginTemplate {
    /**
     * 是否是超级用户(钩子)
     */
    private boolean isSuperUser;

    /**
     * 用户信息（模板方法）
     *
     * @param user
     */
    public boolean login(User user, LoginCallback callback) {
        if (!isSuperUser()) {
            System.out.println("非超级用户必须查询用户信息");
            User findUser = callback.findUser(user);
            if (findUser == null) {
                return false;
            }
        }
        return callback.match(user);
    }

    /**
     * 钩子函数(默认非超级用户)
     *
     * @return
     */
    protected boolean isSuperUser() {
        return false;
    }

}
