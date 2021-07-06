package com.xiaolong.community.common;

import java.lang.annotation.*;

/**
 * 重试机制自定义注解
 * @author dcl
 * @since 3:04 下午 2021/6/8
 */
@Documented
@Inherited
@Target(ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME)
public @interface PreventSubmit {

    /**
     * 重试次数
     */
    int value() default 1;

    /**
     * 重试间隔
     */
    int sleep() default  1000;
}
