package com.ycz.pattern.composite;

/**
 * 客户端测试类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/17 17:27
 * @desc
 */
public class Client {
    public static void main(String[] args) {
        Component component, component1, leaf;
        component = new Composite("服装");
        component1 = new Composite("男装");
        leaf = new Leaf("衣服");
        component1.add(leaf);
        component.add(component1);
        component.operation();
    }
}
