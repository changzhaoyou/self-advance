package com.ycz.pattern.flyweight;

/**
 * ConcreteFlyweight（具体享元类）
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 18:17
 * @desc
 */
public class ConcreteWebSite extends WebSite {

    private String type;

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void published(User user) {
        System.out.println("用户：" + user.getName() + ",发布网站内容:" + this.type);
    }
}
