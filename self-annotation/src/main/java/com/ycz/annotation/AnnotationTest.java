package com.ycz.annotation;

import com.ycz.annotation.domain.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 注解测试类
 *
 * @author ycz
 */
public class AnnotationTest {

    /**
     * 调用展示方法
     *
     * @param student 学生实体
     */
    public void show(@Valid Student student) {
        System.out.println("=======调用show方法========");
        System.out.println(student);
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student("张三", 8);
        AnnotationTest annotationTest = new AnnotationTest();
        annotationTest.show(student);
        Class<? extends AnnotationTest> clazz = annotationTest.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("方法名："+method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                Valid annotation = parameter.getAnnotation(Valid.class);
                if (annotation != null && annotation.value()) {
                    Class<Student> studentClass = Student.class;
                    Field[] declaredFields = studentClass.getDeclaredFields();
                    for (Field field : declaredFields) {
                        field.setAccessible(true);
                        NotBlank notBlankAnnotation = field.getAnnotation(NotBlank.class);
                        Length lengthAnnotation = field.getAnnotation(Length.class);
                        if (field.isAnnotationPresent(NotBlank.class)) {
                            String str = (String) field.get(student);
                            if ("".equals(str) || null == str) {
                                throw new Exception(notBlankAnnotation.message());
                            }
                        }
                        if (field.isAnnotationPresent(Length.class)) {
                            int length = (int) field.get(student);
                            if (length < 8 || length > 30) {
                                throw new Exception(lengthAnnotation.message());
                            }
                        }
                    }
                    method.invoke(annotationTest, student);
                }
            }
        }
    }
}
