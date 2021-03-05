package com.ycz.pattern.iterator;


/**
 * Created by ycz on  2021/02/24/2:54 下午
 */
public interface Aggregate<E> {
    /**
     * 添加元素
     *
     * @param e 元素
     * @return
     */
    boolean add(E e);

    /**
     * 移除元素
     *
     * @param e 元素
     * @return
     */
    boolean remove(E e);

    /**
     * 迭代器
     *
     * @return
     */
    Iterator<E> iterator();

    /**
     * 长度
     *
     * @return
     */
    int size();
}
