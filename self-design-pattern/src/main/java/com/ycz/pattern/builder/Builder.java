package com.ycz.pattern.builder;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/5/8 11:01
 * @desc 抽象建造者
 */
public abstract class Builder {
    /**
     * 具体产品
     */
    protected Product product = new Product();

    /**
     * 构建肤色
     */
    public abstract void buildColour();

    /**
     * 构建头发
     */
    public abstract void buildHair();

    /**
     * 具体产品（如果产品是抽象类，定义抽象方法延迟到子类构建）
     *
     * @return
     */
    public Product getProduct() {
        return product;
    }

    /**
     * 默认构建头发（钩子）
     *
     * @return
     */
    public boolean isBuildHair() {
        return true;
    }
}
