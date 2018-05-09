package com.kobe.alumnus.web.anotaions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验Token注解，有该注解的方法将进行token有效性的校验。
 * Note：使用该注解的方法第一个参数必须是token，否则校验不通过。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ValidToken {
}
