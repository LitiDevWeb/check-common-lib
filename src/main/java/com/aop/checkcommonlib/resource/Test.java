package com.aop.checkcommonlib.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aop.checkcommonlib.annotation.RetryOnFailure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Test {
    private int attemptCounter = 0;

    public Test() {

    }

    @GetMapping("/test")
    public String getAOP() {
        log.info("hey");
        return "hey";

    }

    @GetMapping("/retry")
    @RetryOnFailure(maxAttempts = 3, delayMs = 1000)
    public String testRetry() {
        attemptCounter++;
        log.info("Attempt: " + attemptCounter);
        if (attemptCounter < 3) {
            throw new RuntimeException("Simulated exception");
        }
        return "Success on attempt " + attemptCounter;
    }

}
