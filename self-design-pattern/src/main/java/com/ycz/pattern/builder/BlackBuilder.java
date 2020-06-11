package com.ycz.pattern.builder;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/5/8 11:06
 * @desc 黑人建造者
 */
public class BlackBuilder extends Builder {
    @Override
    public void buildColour() {
        super.product.setColour("黑色");
    }

    @Override
    public void buildHair() {
        super.product.setHair("卷毛");
    }

}
