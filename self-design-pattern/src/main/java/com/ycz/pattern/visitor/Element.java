package com.ycz.pattern.visitor;

/**
 * 抽象元素
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 17:37
 * @desc
 */
public interface Element {
    /**
     * 定义accept方法
     * @param visitor
     */
    void accept(Visitor visitor);
}
