package com.manuelr.javaee.cdi.annotations;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;


/**
 * Interceptor Binding
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface Logged {
}
