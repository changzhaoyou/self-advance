package com.ycz.pattern.iterator;

/**
 * Created by ycz on  2021/02/23/11:08 上午
 */
public class Test {
    public static void main(String[] args) {
        Aggregate<String> aggregate = new AggregateImpl<>();
        for (int i = 0; i < 5; i++) {
            aggregate.add(String.valueOf(i));
        }
        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println("size="+aggregate.size());
    }
}
