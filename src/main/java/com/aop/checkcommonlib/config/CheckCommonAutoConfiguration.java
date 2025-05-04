package com.aop.checkcommonlib.config;

import com.aop.checkcommonlib.aspect.Audit;
import com.aop.checkcommonlib.aspect.ExecutionTimeLog;
import com.aop.checkcommonlib.aspect.Retry;
import com.aop.checkcommonlib.properties.CheckCommonProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@EnableConfigurationProperties(CheckCommonProperties.class)
public class CheckCommonAutoConfiguration {
    @Bean
    @ConditionalOnProperty(name = "check-common.audit-enabled", havingValue = "true", matchIfMissing = true)
    public Audit auditAspect() {
        return new Audit();
    }

    @Bean
    @ConditionalOnProperty(name = "check-common.log-execution-time", havingValue = "true", matchIfMissing = true)
    public ExecutionTimeLog executionTimeAspect() {
        return new ExecutionTimeLog();
    }

    @Bean
    @ConditionalOnProperty(name = "check-common.retry.enabled", havingValue = "true", matchIfMissing = true)
    public Retry retryAspect(CheckCommonProperties properties) {
        return new Retry(properties);
    }
}
