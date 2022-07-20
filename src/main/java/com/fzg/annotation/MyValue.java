package com.fzg.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //生效时间：运行时
@Target(ElementType.FIELD) // 注解位置：属性
public @interface MyValue {
    String value();
}
