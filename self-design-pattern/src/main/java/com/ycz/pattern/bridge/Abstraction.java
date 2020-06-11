package com.ycz.pattern.bridge;

/**
 * 抽象类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/16 17:23
 * @desc
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 操作接口
     */
    public abstract void operation();
}
