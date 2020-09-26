package com.ycz.apm.demo;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/9/25 23:19
 * @desc Java agent demo
 */
public class AgentMain {
    /**
     * java agent 实现插桩植入代码
     * <p>
     * 1.instrumentation addTransformer 类装载拦截
     * 2.只能拦截未装载过的类(instrumentation.addTransformer之前执行过的类，就无法获取该类)
     * 3.instrumentation#retransformClasses方法 重新装载类 ，必须开启相关参数
     * 4.instrumentation.redefineClasses 重新定义一个类 ，不能添加新方法 ，必须开启相关参数
     *
     * @param args            参数变量
     * @param instrumentation java.lang.instrument是在JVM TI的基础上提供的Java版本的实现。
     */
    public static void premain(String args, Instrumentation instrumentation) throws UnmodifiableClassException {
        System.out.println("配置AgentMain args:" + args);
        UserService.class.getName();
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                String classReplace = className.replaceAll("/", ".");
                if ("com.ycz.apm.demo.UserService".equals(classReplace)) {
                    System.out.println(classReplace);
                }
                return null;
            }
        }, true);
        instrumentation.retransformClasses(UserService.class);
    }
}
