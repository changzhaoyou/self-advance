package com.ycz.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:04
 * @desc JDK动态代理-实现(代理类)
 */
public class LogProxyHandler implements InvocationHandler {
    /**
     * 目标类
     */
    private Object target;

    public LogProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----方法:" + method.getName() + "前置处理----");
        Object obj = method.invoke(target, args);
        System.out.println("----方法:" + method.getName() + "后置处理----");
        return obj;
    }
}
