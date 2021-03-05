package com.ycz.proxy.dynamic.cglib;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc Cglib动态代理-接口
 */
public class CglibTest {

    public static void main(String[] args) {
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\ycz\\workspace");
        MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
        HelloService helloService = myMethodInterceptor.getProxyClass(HelloService.class);
        helloService.sayHello("张三");
        helloService.sayThanks("李四");
        UserService userService = myMethodInterceptor.getProxyClass(UserServiceImpl.class);
        userService.sayHello("王五");

        assert 1==1;
        System.out.println(111);
    }
}
