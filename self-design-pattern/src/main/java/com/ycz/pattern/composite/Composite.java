package com.ycz.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器节点对象
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/16 23:43
 * @desc
 */
public class Composite extends Component {
    //存储容器节点
    private List<Component> componentList = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("++" + name);
        for (Object object : componentList) {
            ((Component) object).operation();
        }
    }

    @Override
    public void add(Component component) {
        componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        componentList.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return componentList.get(i);
    }
}
