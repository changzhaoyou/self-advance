package com.ycz.jvm.compiler;

/**
 * Created by ycz on  2021/04/25/8:23 下午
 * -XX:+DoEscapeAnalysis： 表示开启逃逸分析
 * -XX:-DoEscapeAnalysis： 表示关闭逃逸分析 从jdk 1.7开始已经默认开始逃逸分析，如需关闭，需要指定-XX:-DoEscapeAnalysis
 */
public class EscapeAnalysis {
    public String createString(String ... values){
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : values) {
            stringBuffer.append(string+" ");
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        EscapeAnalysis escapeAnalysis = new EscapeAnalysis();
        for (int i = 0; i < 1000000; i++) {
            escapeAnalysis.createString("Escape", "Hello");
        }
        long bufferCost = System.currentTimeMillis() - start;
        System.out.println("craeteString: " + bufferCost + " ms");
    }
}
