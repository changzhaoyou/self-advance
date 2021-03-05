package com.ycz.pattern.observer.async.simple;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zhangzhaoyou
 * 订阅者注册表
 */
final class SubscriberRegistry {

    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> registry = new ConcurrentHashMap<>();

    /**
     * 注册订阅者
     *
     * @param listener
     */
    public void register(Object listener) {
        Map<Class<?>, Collection<Subscriber>> copyOnWriteArraySetMap = findAllSubscribers(listener);
        for (Map.Entry<Class<?>, Collection<Subscriber>> entry : copyOnWriteArraySetMap.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<Subscriber> subscriberCollection = entry.getValue();
            CopyOnWriteArraySet<Subscriber> copyOnWriteArraySet = registry.get(eventType);
            if (copyOnWriteArraySet == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                copyOnWriteArraySet = registry.get(eventType);
            }
            copyOnWriteArraySet.addAll(subscriberCollection);
        }
    }

    /**
     * 解析监听事件对象
     *
     * @param listener 订阅者对象
     * @return
     */
    private Map<Class<?>, Collection<Subscriber>> findAllSubscribers(Object listener) {
        Map<Class<?>, Collection<Subscriber>> collectionMap = new HashMap<>();
        Class<?> clazz = listener.getClass();
        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            CopyOnWriteArraySet<Subscriber> subscriberCopyOnWriteArraySet;
            if (!registry.containsKey(eventType)) {
                subscriberCopyOnWriteArraySet = new CopyOnWriteArraySet<>();
            }else {
                subscriberCopyOnWriteArraySet = registry.get(eventType);
            }
            subscriberCopyOnWriteArraySet.add(new Subscriber(listener, method));
            collectionMap.putIfAbsent(eventType, subscriberCopyOnWriteArraySet);
        }
        return collectionMap;
    }

    /**
     * 解析方法注解
     *
     * @param clazz 订阅者对象Class类
     * @return
     */
    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> methodList = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                //判断Class对象方法参数是否为空
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "方法:%s,参数个数%s", method, parameterTypes.length);
                methodList.add(method);
            }
        }
        return methodList;
    }

    /**
     * 取消订阅者
     *
     * @param listener
     */
    public void unregister(Object listener) {
        Map<Class<?>, Collection<Subscriber>> classCollectionMap = findAllSubscribers(listener);
        for (Map.Entry<Class<?>, Collection<Subscriber>> entry : classCollectionMap.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<Subscriber> subscribers = entry.getValue();
            CopyOnWriteArraySet<Subscriber> copyOnWriteArraySet = registry.get(eventType);
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(subscribers)) {
                throw new IllegalArgumentException("取消注册订阅异常");
            }
        }
    }

    public List<Subscriber> getSubscribers(Object event) {
        List<Subscriber> subscribers = new ArrayList<>();
        Class<?> eventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<Subscriber>> entry : registry.entrySet()) {
            Class<?> key = entry.getKey();
            Collection<Subscriber> subscriberCollection = entry.getValue();
            if (eventType.isAssignableFrom(key)) {
                subscribers.addAll(subscriberCollection);
            }
        }
        return subscribers;
    }
}
