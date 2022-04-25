package com.jpldx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Custom Ribbon Rule Configuration
 *
 * @author chen.xudong
 * @since 1.0.0
 */
@Configuration
public class MyRibbonRule {

    /**
     * 修改 Ribbon 负载均衡规则为：随机
     *
     * @return
     */
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
