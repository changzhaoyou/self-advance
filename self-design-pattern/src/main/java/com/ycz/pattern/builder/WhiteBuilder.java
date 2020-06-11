package com.ycz.pattern.builder;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/5/8 11:06
 * @desc 白人具体构建者
 */
public class WhiteBuilder extends Builder {
    private boolean isBuilderHair;

    public WhiteBuilder(boolean isBuilderHair) {
        this.isBuilderHair = isBuilderHair;
    }

    @Override
    public void buildColour() {
        super.product.setColour("白色");
    }

    @Override
    public void buildHair() {
        super.product.setHair("金毛");
    }

    /**
     * 钩子如果设置成false就不构建具体部件
     *
     * @return
     */
    @Override
    public boolean isBuildHair() {
        return isBuilderHair;
    }
}
