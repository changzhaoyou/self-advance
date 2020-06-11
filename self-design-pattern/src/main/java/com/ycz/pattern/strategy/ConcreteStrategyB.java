package com.ycz.pattern.strategy;

/**
 * 具体策略实现
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 14:40
 * @desc
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("调用--策略B处理");
    }
}
