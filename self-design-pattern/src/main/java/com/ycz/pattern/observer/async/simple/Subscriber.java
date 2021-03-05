package com.ycz.pattern.observer.async.simple;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangzhaoyou
 * 订阅者实体
 */
public class Subscriber {
    private Object target;
    private Method method;

    public Subscriber(Object target, Method method) {
        this.target = target;
        this.method = method;
        method.setAccessible(true);
    }

    /**
     * 调用具体订阅者方法
     * @param event 消息通知体
     */
    public void execute(Object event){
        try {
            method.invoke(target,event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int hashCode() {
        return (31 + method.hashCode()) * 31 + System.identityHashCode(method);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Subscriber) {
            Subscriber that = (Subscriber) obj;
            return target == that.target && method.equals(that.method);
        }
        return false;
    }
}
