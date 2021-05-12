package com.ycz.jvm.compiler;

/**
 * Created by ycz on  2021/04/27/8:26 下午
 */
public class AllocTest {
    public static void main(String[] args) {
        alloc();
    }

    private static void alloc() {
        Point point = new Point(1,2);
        System.out.println("point.x="+point.x+"; point.y="+point.y);
    }
    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
