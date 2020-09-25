package com.ycz.pattern.singleton;

import java.io.Serializable;

/**
 * 饿汉单例模式
 */
public class EagerSingleton implements Serializable {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        if (instance == null) {
            throw new RuntimeException("禁止通过反射获取实例");
        }
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
