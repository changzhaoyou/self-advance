package com.ycz.jvm.compiler;

/**
 * AOT编译器
 * Created by ycz on  2021/04/22/5:55 下午
 */
public class JaotCompilation {

    public static void main(String[] argv) {
        System.out.println(message());
    }

    public static String message() {
        return"The JAOT compiler says 'Hello'";
    }
}