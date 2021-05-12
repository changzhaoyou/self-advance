package com.ycz.jvm.compiler;

/**
 * Created by ycz on  2021/04/22/3:30 下午
 */
public class Test02 {

    public void method(String... strings) {
        System.out.println(strings);
    }

    public static void main(String[] args) {
        if (true) {
            System.out.println("a");
        } else {
            System.out.println("b");
        }
    }


}
