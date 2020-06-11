package com.ycz.pattern.adapter;

/**
 * 类适配器
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/11 23:37
 * @desc
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.specialRequest();
    }
}
