package com.ycz.pattern.adapter;

/**
 * 客户端类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/11 23:34
 * @desc
 */
public class AdapterClient {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request();
    }
}
