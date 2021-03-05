package com.ycz.proxy.dynamic.jdk;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:04
 * @desc 动态代理测试类
 */
public class ProxyTest {

    public static void main(String[] args) {
        //会在工作目录中，生成代理类字节码文件
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloService proxy = new HelloServiceImpl();
        HelloService helloService = (HelloService) new LogProxyHandler().bind(proxy);
        helloService.sayHello("张三");
    }
}
