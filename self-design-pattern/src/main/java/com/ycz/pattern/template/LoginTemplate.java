package com.ycz.pattern.template;

/**
 * 登录模板方法
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 16:13
 * @desc
 */
abstract class LoginTemplate {
    /**
     * 是否是超级用户(钩子)
     */
    private boolean isSuperUser;

    /**
     * 用户信息（模板方法）
     *
     * @param user
     */
    public boolean login(User user) {
        if (!isSuperUser()) {
            System.out.println("非超级用户必须查询用户信息");
            User findUser = this.findUser(user);
            if (findUser == null) {
                return false;
            }
        }
        return this.match(user);
    }

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    private User findUser(User user) {
        //获取数据库用户信息，为了测试方便
        if (user.getId() == null) {
            return null;
        }
        return user;
    }

    /**
     * 匹配用户账号密码
     *
     * @param user
     * @return
     */
    protected abstract boolean match(User user);

    /**
     * 钩子函数(默认非超级用户)
     *
     * @return
     */
    protected boolean isSuperUser() {
        return false;
    }

}
