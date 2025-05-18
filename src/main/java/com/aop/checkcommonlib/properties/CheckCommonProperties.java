// package com.aop.checkcommonlib.properties;

// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @EnableAspectJAutoProxy
// @ConfigurationProperties(prefix = "check-common")
// public class CheckCommonProperties {
//     private boolean auditEnabled = true;
//     private boolean logExecutionTime = true;
//     private RetryProperties retry = new RetryProperties();

//     public boolean isAuditEnabled() { return auditEnabled; }
//     public void setAuditEnabled(boolean auditEnabled) { this.auditEnabled = auditEnabled; }
//     public boolean isLogExecutionTime() { return logExecutionTime; }
//     public void setLogExecutionTime(boolean logExecutionTime) { this.logExecutionTime = logExecutionTime; }
//     public RetryProperties getRetry() { return retry; }
//     public void setRetry(RetryProperties retry) { this.retry = retry; }

//     public static class RetryProperties {
//         private boolean enabled = true;
//         private int defaultMaxAttempts = 3;
//         private long defaultDelayMs = 500;

//         public boolean isEnabled() { return enabled; }
//         public void setEnabled(boolean enabled) { this.enabled = enabled; }
//         public int getDefaultMaxAttempts() { return defaultMaxAttempts; }
//         public void setDefaultMaxAttempts(int defaultMaxAttempts) { this.defaultMaxAttempts = defaultMaxAttempts; }
//         public long getDefaultDelayMs() { return defaultDelayMs; }
//         public void setDefaultDelayMs(long defaultDelayMs) { this.defaultDelayMs = defaultDelayMs; }
//     }
// }
