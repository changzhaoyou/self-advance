package com.ycz.pattern.template.callback;

import com.ycz.pattern.template.User;

/**
 * 测试类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 17:00
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        User ordinary = new User();
        ordinary.setId(1);
        ordinary.setName("ordinary");
        ordinary.setPassword("123456");
        LoginTemplate loginTemplate = new LoginTemplate();
        boolean isLogin = loginTemplate.login(ordinary, new LoginCallback() {
            @Override
            public User findUser(User user) {
                //获取数据库用户信息，为了测试方便
                if (user.getId() == null) {
                    return null;
                }
                return user;
            }

            @Override
            public boolean match(User user) {
                System.out.println("调用普通用户匹配账号密码，名称：" + user.getName());
                if (user.getName() != null && "ordinary".equals(user.getName())) {
                    return true;
                }
                return false;
            }
        });
        System.out.println("登录是否成功：" + isLogin);
    }
}
