package com.ycz.jvm.compiler;

import java.io.IOException;

/**
 * -Xmx4G -Xms4G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * Created by ycz on  2021/04/27/7:14 下午
 */
public class DoEscapeAnalysis {

    public static void main(String[] args) throws IOException {
        long a1 = System.currentTimeMillis();
        //100w实例
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        // 查看执行时间
        long a2 = System.currentTimeMillis();
        System.out.println("cost " + (a2 - a1) + " ms");
        // 为了方便查看堆内存中对象个数，线程sleep
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
        System.in.read();
    }

    private static void alloc() {
        User user = new User();
    }

    static class User {

    }
}
