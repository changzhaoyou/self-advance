package com.ycz.pattern.adapter;

/**
 * 适配者类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/11 23:29
 * @desc
 */
public class Adaptee {
    /**
     * 具体实现
     */
    public void specialRequest() {
        System.out.println("适配者类接口调用");
    }
}
