package com.ycz.pattern.iterator;

/**
 * Created by ycz on  2021/02/24/2:50 下午
 * 迭代器接口
 */
public interface Iterator<E> {
    /**
     * 是否含有下一元素
     *
     * @return
     */
    boolean hasNext();

    /**
     * 返回前一个元素
     *
     * @return
     */
    E next();

    /**
     * 移除元素
     * @return
     */
    boolean remove();
}
