package com.ycz.pattern.adapter;

/**
 * 适配器类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/11 23:29
 * @desc
 */
public class Adapter implements Target {
    //被适配者
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("调用适配器");
        adaptee.specialRequest();
    }
}
