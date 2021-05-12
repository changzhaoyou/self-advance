package com.ycz.jvm.compiler;

/**
 * 即时编译触发
 * Created by ycz on  2021/04/25/11:33 上午
 */
public class CyclicTest {

    public void nlp() {
        int sum = 0;
        for (int i = 0; i < 200; i++) {
            sum += i;
        }
    }
}
