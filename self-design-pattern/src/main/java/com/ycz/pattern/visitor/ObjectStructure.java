package com.ycz.pattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 对象结构
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 17:40
 * @desc
 */
public class ObjectStructure {
    /**
     * 对象集合
     */
    private List<Element> elementList = new ArrayList<>();

    /**
     * 开始调用访问者
     *
     * @param visitor
     */
    public void accept(Visitor visitor) {
        Iterator<Element> iterator = elementList.iterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            element.accept(visitor);
        }
    }

    /**
     * 添加元素
     *
     * @param element
     */
    public boolean addElement(Element element) {
        return elementList.add(element);
    }

    /**
     * 移除元素
     *
     * @param element
     */
    public boolean removeElement(Element element) {
        if (elementList != null && elementList.size() > 0) {
            return elementList.remove(element);
        }
        return false;
    }
}