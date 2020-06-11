package com.ycz.pattern.template;

/**
 * 普通用户具体模板子类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 16:29
 * @desc
 */
public class OrdinaryUser extends LoginTemplate {

    @Override
    public boolean match(User user) {
        System.out.println("调用普通用户匹配账号密码，名称：" + user.getName());
        if (user.getName() != null && "ordinary".equals(user.getName())) {
            return true;
        }
        return false;
    }
}
