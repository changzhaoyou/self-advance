package com.ycz.jvm.compiler;

import java.util.Arrays;
import java.util.List;
//静态static关键字导入包
//import static java.lang.Math.*;
/**
 * Created by ycz on  2021/04/22/3:08 下午
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
        //静态static关键字导入包，可以直接使用方法
        //abs(1);
    }
}
