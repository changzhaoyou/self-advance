package com.ycz.annotation;

import java.lang.annotation.*;

/**
 * @author ycz
 * @date 2020-07-05
 * @Desc 开启是否校验标识
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Valid {
    /**
     * 默认开启校验
     *
     * @return
     */
    boolean value() default true;

    /**
     * 嵌套注解
     *
     * @return
     */
    Param[] getStr() default {};
}
