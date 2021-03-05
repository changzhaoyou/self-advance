package com.ycz.pattern.iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by ycz on  2021/02/24/3:01 下午
 * 具体容器迭代器
 */
public class AggregateIterator<E> implements Iterator<E> {
    /**
     * 游标
     */
    private int cursor;
    /**
     * 游标最后一个元素
     */
    private int lastRet = -1;
    /**
     * 集合
     */
    private ArrayList arrayList;

    public AggregateIterator(ArrayList list) {
        this.arrayList = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();
    }

    @Override
    public E next() {
        int i = cursor;
        if (i >= arrayList.size()) {
            throw new NoSuchElementException();
        }
        cursor = i + 1;
        lastRet = i;
        return (E) arrayList.get(lastRet);
    }

    @Override
    public boolean remove() {
        boolean removeFlag = arrayList.remove(lastRet) != null;
        cursor = lastRet;
        return removeFlag;
    }
}
