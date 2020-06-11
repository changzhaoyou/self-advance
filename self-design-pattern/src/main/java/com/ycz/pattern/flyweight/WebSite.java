package com.ycz.pattern.flyweight;

/**
 * Flyweight（享元抽象类）
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/20 10:35
 * @desc
 */
public abstract class WebSite {
    /**
     * 享元公共方法
     * @param user
     */
    public abstract void published(User user);
}
