package com.ycz.pattern.singleton;

/**
 * 懒汉式模式
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {

    }
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
            return instance;
        }
        return instance;
    }
}
