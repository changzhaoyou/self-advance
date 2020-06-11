package com.ycz.pattern.bridge;

/**
 * 具体实现接口类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/16 17:28
 * @desc
 */
public class ConcreteImpl implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("调用实现类。。。。。");
    }
}
