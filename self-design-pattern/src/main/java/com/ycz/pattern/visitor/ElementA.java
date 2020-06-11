package com.ycz.pattern.visitor;

/**
 * 具体元素抽象方法
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 17:38
 * @desc
 */
public class ElementA implements Element {
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
        this.name = "张三";
        this.age = 17;
        visitor.visitorElementA(this);
    }
}
