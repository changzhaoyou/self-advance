package com.ycz.pattern.template;

/**
 * 用户信息
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 16:15
 * @desc
 */
public class User {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
