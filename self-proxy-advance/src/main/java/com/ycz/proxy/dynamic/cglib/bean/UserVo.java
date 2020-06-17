package com.ycz.proxy.dynamic.cglib.bean;

import java.io.Serializable;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc Cglib实现对象拷贝
 */
public class UserVo implements Serializable {
    /**
     * 名称
     */
    private String name;
    /**
     * 年纪
     */
    private int age;
    /**
     * 地址
     */
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
