package com.ycz.pattern.strategy;

/**
 * 环境类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 14:38
 * @desc
 */
public class Context {
    /**
     * 抽象策略类
     */
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 调用具体策略算法
     */
    public void algorithm() {
        strategy.algorithm();
    }
}
