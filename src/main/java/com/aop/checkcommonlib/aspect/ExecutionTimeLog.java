package com.aop.checkcommonlib.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ExecutionTimeLog {
    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeLog.class);

    @Around("execution(* *(..)) && !within(com.aop.checkcommonlib..*)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        logger.info("Execution time of {}: {} ms", joinPoint.getSignature(), duration);
        return proceed;
    }
}
