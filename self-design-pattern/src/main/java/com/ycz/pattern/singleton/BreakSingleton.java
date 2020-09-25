package com.ycz.pattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 破坏单例模式
 * 1.通过反射机制破坏单例模式（本质调用反射方法）
 *      解决办法：在构造函数中，判断实例是否存在，throw new RuntimeException("禁止通过反射获取实例");
 * 2.通过序列化方式破坏单例模式（本质调用反射方法）
 *      解决办法：(1)、被序列化对象不实现Serializable,对象不可序列化
 *              (2)、实现了序列化对象了，在该类中实现readResolve方法中返回单例对象，就不会被破坏单例
 *              示例：
 *              private Object readResolve(){
 *                  //当前类的单例对象
 *                  return hungrySingleton;
 *              }
 *              原理：IO流中调用反射的代码
 *
 * @author ycz
 */
public class BreakSingleton {

    public static void main(String[] args) throws Exception {
        //1、反射方式进行破坏单例模式
        // invoke();
        //2、序列化方式破坏单例模式
        serializable();

    }

    /**
     * 序列化方式
     */
    private static void serializable() throws Exception {
        //获取单例实例
        LazySingleton instance = LazySingleton.getInstance();
        //通过序列化获取实例
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("lazy_singleton_file"));
        objectOutputStream.writeObject(instance);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("lazy_singleton_file")));
        LazySingleton newInstance = (LazySingleton) objectInputStream.readObject();
        System.out.println("单例中获取:" + instance);
        System.out.println("序列化对象:" + newInstance);
        System.out.println(instance == newInstance);
    }

    /**
     * 反射方式
     */
    private static void invoke() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<LazySingleton> singletonClass = LazySingleton.class;
        Constructor<LazySingleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazySingleton newInstance = declaredConstructor.newInstance();
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
        /**
         * com.ycz.pattern.singleton.LazySingleton@4554617c
         * com.ycz.pattern.singleton.LazySingleton@74a14482
         * false
         */
        Class<EagerSingleton> eagerSingletonClass = EagerSingleton.class;
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton newEagerSingleton = eagerSingletonClass.newInstance();
        System.out.println(eagerSingleton == newEagerSingleton);
    }
}
