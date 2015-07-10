package com.mttch.admin.server.mybatis.helpers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DatabaseValue {
    String stringValue() default "";
    int intValue() default Integer.MIN_VALUE;
}
