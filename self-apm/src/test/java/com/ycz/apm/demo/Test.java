package com.ycz.apm.demo;

/**
 * Created by ycz on  2021/03/22/5:07 下午
 */
public class Test {

    public static void main(String[] args) {
        int origin=7;
        System.out.println(String.format("%32s", Integer.toBinaryString(origin)).replace(' ', '0'));
    }
}
