package com.aop.checkcommonlib.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface RetryOnFailure {
    int maxAttempts() default 3;

    long delayMs() default 500;

    Class<? extends Throwable>[] include() default {};

    Class<? extends Throwable>[] exclude() default {};
}

