package com.ycz.pattern.flyweight;

/**
 * UnsharedConcreteFlyweight（非共享具体享元类）
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 18:13
 * @desc
 */
public class User {
    private String name;
    private int age;

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
}
