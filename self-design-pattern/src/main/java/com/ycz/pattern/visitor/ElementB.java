package com.ycz.pattern.visitor;

/**
 * 具体元素
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 17:39
 * @desc
 */
public class ElementB implements Element {
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

    @Override
    public void accept(Visitor visitor) {
        this.name = "李四";
        this.age = 50;
        visitor.visitorElementB(this);
    }
}
