package com.ycz.annotation;

import java.lang.annotation.*;

/**
 * @author ycz
 * @date 2020-07-05
 * @Desc 范围判断
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Length {
    /**
     * 最大值
     *
     * @return
     */
    int max() default Integer.MAX_VALUE;

    /**
     * 最小值
     *
     * @return
     */
    int min() default 0;

    /**
     * 提示信息
     *
     * @return
     */
    String message() default "";
}
