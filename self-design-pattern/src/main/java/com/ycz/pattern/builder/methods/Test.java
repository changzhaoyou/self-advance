package com.ycz.pattern.builder.methods;

public class Test {
    public static void main(String[] args) {
        User user=new User.Builder()
                .setName("张三")
                .setAddress("广东省深圳市")
                .setAge(30)
                .setCity("深圳")
                .build();
        System.out.println(user);
    }
}
