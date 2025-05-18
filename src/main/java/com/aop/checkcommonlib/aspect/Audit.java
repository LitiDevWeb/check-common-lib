package com.aop.checkcommonlib.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@Aspect
public class Audit {

    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("Entering method: {} with arguments: {}", joinPoint.getSignature(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "@within(org.springframework.web.bind.annotation.RestController", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        log.info("Exiting method: {} with result: {}", joinPoint.getSignature(), result);
    }
}
