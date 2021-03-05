package com.ycz.pattern.template.hook;

/**
 * @author zhangzhaoyou
 * 钩子
 */
public class ShutdownHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Hook());
        System.out.println("主线程结束");
    }

    static class Hook extends Thread{
        @Override
        public void run() {
            System.out.println("JVM关闭前,调用此线程");
        }
    }
}
