package com.ycz.pattern.adapter;

/**
 * 具体实现类
 * @author ycz
 * @version 1.0
 * @date 2020/5/12 22:05
 * @desc
 */
public class ConcreteInterface extends DefaultInterface {
    @Override
    public void request() {
        System.out.println("重写缺省接口");
    }
}
