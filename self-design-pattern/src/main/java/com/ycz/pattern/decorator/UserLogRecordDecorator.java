package com.ycz.pattern.decorator;

/**
 * 具体装饰器类的子类（ConcreteDecorator）
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/17 23:37
 * @desc
 */
public class UserLogRecordDecorator extends UserDecorator {

    public UserLogRecordDecorator(UserService userService) {
        super(userService);
    }

    @Override
    public void login(String userName) {
        recordLog(userName);
        super.login(userName);
    }

    /**
     * 扩充用户登录职责（记录登录日志）
     *
     * @param userName
     */
    public void recordLog(String userName) {
        System.out.println("记录用户：" + userName + "登录日志");
    }
}
