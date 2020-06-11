package com.ycz.pattern.composite;

/**
 * 叶子节点
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/17 17:12
 * @desc
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("-----" + name + "----");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("不支持该功能");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("不支持该功能");
    }

    @Override
    public Component getChild(int i) {
        throw new UnsupportedOperationException("不支持该功能");
    }
}
