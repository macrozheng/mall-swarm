package com.macro.mall.common.annotation;

import java.lang.annotation.*;

/**
 * Custom annotation, the cache method with this annotation will throw an exception
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
