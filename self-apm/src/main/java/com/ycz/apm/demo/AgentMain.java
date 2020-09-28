package com.ycz.apm.demo;

import javassist.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/9/25 23:19
 * @desc Java agent demo
 */
public class AgentMain {
    /**
     * 被代理类路径
     */
    private final static String classPath = "com.ycz.apm.demo.UserService";

    /**
     * java agent 实现插桩植入代码
     * javassist 代码植入
     *
     * @param args            参数变量
     * @param instrumentation java.lang.instrument是在JVM TI的基础上提供的Java版本的实现。
     */
    public static void premain(String args, Instrumentation instrumentation) throws Exception {
        System.out.println("配置AgentMain args:" + args);
        redefineClass(instrumentation);
        modifyByteCode(instrumentation);
    }

    /**
     * javassist 实例代码
     *
     * @param instrumentation
     */
    private static void modifyByteCode(Instrumentation instrumentation) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        classPool.appendSystemPath();
        CtClass ctClass = classPool.get(classPath);
        CtMethod sayHiMethod = ctClass.getDeclaredMethod("sayHi");
        CtMethod newMethod = CtNewMethod.copy(sayHiMethod, ctClass, null);
        String invokeNewMethod = sayHiMethod.getName() + "$agent";
        sayHiMethod.setName(invokeNewMethod);
        newMethod.setBody("{" +
                "long beginTime = System.currentTimeMillis();\n" +
                "System.out.println(\"请求参数：\"+$1);\n" +
                "sayHi$agent($1,$2);" +
                "System.out.println(\"执行方法耗时：\" + (System.currentTimeMillis() - beginTime));\n" +
                "return $1;" +
                "}");
        ctClass.addMethod(newMethod);
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "checkState", new CtClass[]{}, ctClass);
        ctMethod.addParameter(CtClass.booleanType);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{" +
                "System.out.println(\"请求参数：\"+$1);\n" +
                "}");
        ctClass.addMethod(ctMethod);
        Class toClass = ctClass.toClass();
        //生产动态植入的代码到工程目录
        ctClass.debugWriteFile();
        new UserService().sayHi("UserService SayHello method", 18);
        //通过反射获取类，动态植入的代码
        Object newInstance = toClass.newInstance();
        Method checkState = newInstance.getClass().getDeclaredMethod("checkState", new Class[]{boolean.class});
        checkState.invoke(newInstance, Boolean.TRUE);
    }

    /**
     * 1.instrumentation addTransformer 类装载拦截
     * 2.只能拦截未装载过的类
     * 3.instrumentation#retransformClasses方法 重新装载类 ，必须开启相关参数
     * 4.instrumentation.redefineClasses 重新定义一个类 ，不能添加新方法 ，必须开启相关参数
     *
     * @param instrumentation
     * @throws UnmodifiableClassException
     */
    private static void redefineClass(Instrumentation instrumentation) throws UnmodifiableClassException {
        //加载UserService类
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
        //重新加载类
        instrumentation.retransformClasses(UserService.class);
    }
}
