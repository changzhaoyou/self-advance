package com.ycz.proxy.dynamic.cglib.bean;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/16 14:01
 * @desc Cglib实现对象拷贝
 * 1、属性名称相同类型相同的属性拷贝OK。
 * 2、属性名称相同而类型不同的属性不会被拷贝。（即使源类型是原始类型(int, short和char等)，目标类型是其包装类型(Integer, Short和Character等)，或反之：都 不会被拷贝。 ）
 * 3、
 */
public class BeanCopyTest {

    public static void main(String[] args) {
        UserVo userVo = new UserVo();
        userVo.setAge(10);
        userVo.setName("张三");
        userVo.setAddress("广东省深圳市.....");
        UserDo userDo = new UserDo();
        BeanCopier beanCopier = BeanCopier.create(UserVo.class, UserDo.class, true);
        beanCopier.copy(userVo, userDo, new Converter() {
            @Override
            public Object convert(Object value, Class target, Object context) {
                //自定义类型转化 定义时间类型转化
                if (value instanceof Integer) {
                    return value;
                } else if (value instanceof String) {
                    return value;
                }
                return value;
            }
        });
        System.out.println(userVo);
        System.out.println(userDo);
        System.out.println("===============加入转化器================");


    }
}
