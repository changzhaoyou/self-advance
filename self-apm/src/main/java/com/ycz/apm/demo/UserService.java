package com.ycz.apm.demo;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/9/26 0:08
 * @desc user agent instance
 */
public class UserService {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public UserService() {
    }

    /**
     * 普通方法
     *
     * @param msg 参数变量
     * @return
     */
    public String sayHello(String msg) {
        return msg;
    }

}
