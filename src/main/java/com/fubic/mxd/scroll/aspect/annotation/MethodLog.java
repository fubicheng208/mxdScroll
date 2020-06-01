package com.fubic.mxd.scroll.aspect.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface MethodLog {
    String description() default "";
}
