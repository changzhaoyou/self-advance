package com.ycz.pattern.singleton;

/**
 * 枚举模式
 */
public enum EunmSingleton {

    instance;

    public static EunmSingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        EunmSingleton singleton1=EunmSingleton.getInstance();
        EunmSingleton singleton2=EunmSingleton.getInstance();
        EunmSingleton singleton3=EunmSingleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1 == singleton3);
        System.out.println(singleton2 == singleton3);
        /***
         * true
         * true
         * true
         */
    }
}
