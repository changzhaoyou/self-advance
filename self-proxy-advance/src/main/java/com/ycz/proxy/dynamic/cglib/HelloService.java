package com.ycz.proxy.dynamic.cglib;/** * @author ycz * @version 1.0 * @date 2020/6/16 14:01 * @desc Cglib动态代理-被代理对象 */public class HelloService {    /**     * 私有方法     *     * @param name     */    public void sayHello(String name) {        System.out.println("name:" + name + ",hello world!!!");    }    /**     * 公有方法     *     * @param name     */    public void sayThanks(String name) {        System.out.println("name:" + name + ",Thank you !!!");    }    /**     * 静态方法     */    public static void sayStatic() {        System.out.println("11111111111");    }}