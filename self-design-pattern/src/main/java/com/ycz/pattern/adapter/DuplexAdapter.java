package com.ycz.pattern.adapter;

/**
 * 双向适配器
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/11 23:40
 * @desc
 */
public class DuplexAdapter {
    /**
     * 目标类
     */
    private Target target;
    /**
     * 被适配者类
     */
    private Adaptee adaptee;

    public DuplexAdapter(Target target, Adaptee adaptee) {
        this.target = target;
        this.adaptee = adaptee;
    }

    /**
     * 调用被适配者
     */
    public void specialRequest() {
        adaptee.specialRequest();
    }

    /**
     * 调用目标类
     */
    public void request(){
        target.request();;
    }
}
