package com.ycz.pattern.singleton;

import java.io.Serializable;

/**
 * 懒汉式模式
 */
public class LazySingleton implements Serializable {

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

    /**
     * 避免序列化后，序列化对象不是同一个对象破坏单例
     *  原理：
     *
     * @return
     */
    public LazySingleton readResolve() {
        return LazySingleton.getInstance();
    }
}
