package com.ycz.pattern.expression;

/**
 * Created by ycz on  2021/02/26/5:01 下午
 * 抽象表达式类
 */
public interface Expression {

    boolean interpret(String info);
}
