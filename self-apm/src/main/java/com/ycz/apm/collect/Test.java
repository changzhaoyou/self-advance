package com.ycz.apm.collect;

public class Test {
    public static void main(String[] args) {
//        float a =22.121222222222222222222F;
//        System.out.println(a);
//        double b =22.1212222222222223432233223233223233223222222D;
//        System.out.println(b);
//        int c=1024;
//        System.out.println(c>>3);
//        System.out.println(c<<2);
//        System.out.println(1<<30);
//        int d=2147483647;
//        System.out.println("二进制："+Integer.toBinaryString(d));
//        System.out.println("十进制："+d);
//        System.out.println("八进制："+Integer.toOctalString(d));
//        System.out.println("十六进制："+Integer.toHexString(d).toUpperCase());
        int f =82;
        System.out.println("二进制f：0"+Integer.toBinaryString(f));
        int g=169;
        System.out.println("二进制g："+Integer.toBinaryString(g));
        System.out.println("f:>>1 = "+(f>>1));
        System.out.println("f:<<1 = "+(f<<1));
        System.out.println("f:f>>>1="+(f>>>1));
        int h=(f&g);
        System.out.println("f&g "+Integer.toBinaryString(h));
        System.out.println("f|g "+Integer.toBinaryString(f|g));
        System.out.println("f^g "+Integer.toBinaryString(f^g));
        System.out.println("65536 "+Integer.toBinaryString(65535));
        System.out.println("~取反 "+Integer.toBinaryString(~65535));
        System.out.println(~65535);
        System.out.println("20201106023922".hashCode()%30);
    }
}
