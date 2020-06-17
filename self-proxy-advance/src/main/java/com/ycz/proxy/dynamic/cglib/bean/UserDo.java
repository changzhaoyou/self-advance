package com.ycz.proxy.dynamic.cglib.bean;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc Cglib实现对象拷贝
 */
public class UserDo {
    /**
     * 名称
     */
    private String names;
    /**
     * 年纪
     */
    private int age;
    /**
     * 地址
     */
    private String address;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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
                "names='" + names + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
