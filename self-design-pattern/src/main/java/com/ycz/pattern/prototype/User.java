package com.ycz.pattern.prototype;

/**
 * 深拷贝：实现Cloneable接口，重新clone方法，引用对象也需要重新clone方法才能进行深拷贝
 */
public class User implements Cloneable {
    private int age;
    private String name;
    /**
     * 需要进行深拷贝
     */
    private UserDetail userDetail;

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 重写clone方法，引用对象进行深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.setUserDetail(this.userDetail.clone());
        return user;
    }
}
