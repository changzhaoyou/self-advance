package com.ycz.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ycz
 * @date 2020-07-07
 * @Desc
 */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Param {
    /**
     * 默认字符数组
     *
     * @return
     */
    String[] strs() default {};
}
