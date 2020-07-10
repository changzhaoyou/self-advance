package com.ycz.annotation.domain;

import com.ycz.annotation.Length;
import com.ycz.annotation.NotBlank;

/**
 * 学生实体
 *
 * @author ycz
 */
public class Student {
    /**
     * 学生姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String name;
    /**
     * 学生年龄
     */
    @Length(min = 8, max = 30, message = "学生年龄必须在范围8-30")
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
