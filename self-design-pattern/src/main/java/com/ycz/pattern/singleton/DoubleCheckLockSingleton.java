package com.ycz.pattern.singleton;

/**
 * 双重检查锁模式
 */
public class DoubleCheckLockSingleton {
    /**
     * 解决指令重排和可见性
     */
    private static volatile DoubleCheckLockSingleton instance = null;

    private DoubleCheckLockSingleton() {

    }

    public static DoubleCheckLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingleton();
                    return instance;
                }
            }
        }
        return instance;
    }

}
