package com.ycz.annotation;

import java.lang.annotation.*;

/**
 * @author ycz
 * @date 2020-07-05
 * @Desc 非空校验
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface NotBlank {
    /**
     * 提示参数
     *
     * @return
     */
    String message() default "";
}
