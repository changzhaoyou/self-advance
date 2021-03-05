package com.ycz.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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

    /**
     *
     * loader：一个classloader对象，定义了由哪个classloader对象对生成的代理类进行加载
     * interfaces：一个interface对象数组，表示我们将要给我们的代理对象提供一组什么样的接口，如果我们提供了这样一个接口对象数组，那么也就是声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法。
     * InvocationHandler：一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。
     */
    public Proxy bind(Object target) {
        this.target = target;
        return (Proxy) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    /**
     * proxy:代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * method:我们所要调用某个对象真实的方法的Method对象
     * args:指代代理对象方法传递的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----方法:" + method.getName() + "前置处理----");
        Object obj = method.invoke(target, args);
        System.out.println("----方法:" + method.getName() + "后置处理----");
        return obj;
    }
}
