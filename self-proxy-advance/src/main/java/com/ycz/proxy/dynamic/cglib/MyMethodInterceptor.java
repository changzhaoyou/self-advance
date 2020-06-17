package com.ycz.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc Cglib动态代理-代理类
 */
public class MyMethodInterceptor implements MethodInterceptor {
    /**
     * 获取目标类
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getProxyClass(Class clazz) {
        //创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(clazz);
        //这里的create方法就是正式创建代理类
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法名：" + method.getName() + "调用前");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("方法名：" + method.getName() + "调用后");
        return object;
    }
}
