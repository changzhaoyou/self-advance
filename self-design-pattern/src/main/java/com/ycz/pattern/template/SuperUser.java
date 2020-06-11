package com.ycz.pattern.template;

/**
 * 具体实现模板子类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 16:31
 * @desc
 */
public class SuperUser extends LoginTemplate {

    @Override
    public boolean match(User user) {
        System.out.println("调用超级用户账号密码，用户名称：" + user.getName());
        if ("admin".equals(user.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isSuperUser() {
        return true;
    }
}
