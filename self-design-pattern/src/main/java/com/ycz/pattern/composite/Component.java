package com.ycz.pattern.composite;

/**
 * 抽象构件
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/17 17:10
 * @desc
 */
public abstract class Component {
    /**
     * 节点名称
     */
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 公共抽象方法
     */
    public abstract void operation();

    /**
     * 添加节点
     *
     * @param component
     */
    public abstract void add(Component component);

    /**
     * 删除节点
     *
     * @param component
     */
    public abstract void remove(Component component);

    /**
     * 获取节点
     *
     * @param i
     * @return
     */
    public abstract Component getChild(int i);
}
