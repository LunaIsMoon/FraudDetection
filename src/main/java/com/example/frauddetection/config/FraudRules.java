package com.example.frauddetection.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * 实际的欺诈规则是复杂的，而且是动态变化的，可以考虑使用nacos作为配置中心可以动态修改相关配置
 */
@Component
@ConfigurationProperties(prefix = "fraud.rules")
@Data
public class FraudRules {
    private BigDecimal amountLimit;
    private List<String> accountIdList;
}
