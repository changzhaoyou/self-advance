package com.ycz.pattern.prototype;

import java.util.Date;

/**
 * 原型类(浅拷贝)
 */
public class Prototype implements Cloneable {
    private int age;
    private String name;
    /**
     * 引用类型对象
     */
    private Detail detail;

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
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
     * 重写clone()方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }


    @Override
    public String toString() {
        return "Prototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", detail=" + detail +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setAge(20);
        prototype.setName("张三");
        prototype.setDetail(new Detail("abc", new Date(1000000000000L)));
        System.out.println("源对象:" + prototype);
        System.out.println("====================================================");
        Prototype prototype1 = (Prototype) prototype.clone();
        Detail detail = prototype1.getDetail();
        detail.setMsg("DEF");
        System.out.println("克隆后，修改引用类型后：" + prototype1);
        System.out.println("====================================================");
        System.out.println("修改克隆对象后，源对象：" + prototype);
        /**
         * 源对象:Prototype{age=20, name='张三', detail=Detail{msg='abc', date=Sun Sep 09 09:46:40 CST 2001}}
         * ====================================================
         * 克隆后，修改引用类型后：Prototype{age=20, name='张三', detail=Detail{msg='DEF', date=Sun Sep 09 09:46:40 CST 2001}}
         * ====================================================
         * 修改克隆对象后，源对象：Prototype{age=20, name='张三', detail=Detail{msg='DEF', date=Sun Sep 09 09:46:40 CST 2001}}
         */
    }
}
