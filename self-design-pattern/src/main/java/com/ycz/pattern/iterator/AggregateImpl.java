package com.ycz.pattern.iterator;

import java.util.ArrayList;

/**
 * Created by ycz on  2021/02/24/2:58 下午
 * 集合容器
 */
public class AggregateImpl<E> implements Aggregate<E> {

    private ArrayList arrayList = new ArrayList();

    @Override
    public boolean add(E e) {
        return arrayList.add(e);
    }

    @Override
    public boolean remove(E e) {
        return arrayList.remove(e);
    }

    @Override
    public Iterator<E> iterator() {
        return new AggregateIterator(arrayList);
    }

    @Override
    public int size() {
        return arrayList.size();
    }
}
