package com.aop.checkcommonlib.config;

import com.aop.checkcommonlib.aspect.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class CheckCommonAutoConfiguration {
    @Bean
    @ConditionalOnProperty(name = "check-common.audit-enabled", havingValue = "true", matchIfMissing = false)
    public Audit auditAspect() {
        return new Audit();
    }

    @Bean
    @ConditionalOnProperty(name = "check-common.log-execution-time", havingValue = "true", matchIfMissing = false)
    public ExecutionTimeLog executionTimeAspect() {
        return new ExecutionTimeLog();
    }

    @Bean
    @ConditionalOnProperty(name = "check-common.retry.enabled", havingValue = "true", matchIfMissing = false)
    public Retry retryAspect() {
        return new Retry();
    }
}
