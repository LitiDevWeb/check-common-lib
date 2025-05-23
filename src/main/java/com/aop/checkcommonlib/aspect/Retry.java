package com.aop.checkcommonlib.aspect;

import com.aop.checkcommonlib.annotation.RetryOnFailure;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Retry {

    public Retry() {
    }

    @Around("@annotation(retryOnFailure)")
    public Object retry(ProceedingJoinPoint pjp, RetryOnFailure retryOnFailure) throws Throwable {
        int attempts = 0;
        int maxAttempts = retryOnFailure.maxAttempts();
        long delay = retryOnFailure.delayMs();

        while (true) {
            try {
                return pjp.proceed();
            } catch (Throwable t) {
                attempts++;
                if (attempts >= maxAttempts) {
                    throw t;
                }
                Thread.sleep(delay);
            }
        }
    }
}
