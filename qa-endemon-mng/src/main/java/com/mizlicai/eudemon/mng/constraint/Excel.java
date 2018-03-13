package com.mizlicai.eudemon.mng.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tinyba1 on 2016/11/14/0014.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {
    String exportName();

    int exportFieldWidth() default 10;
}
