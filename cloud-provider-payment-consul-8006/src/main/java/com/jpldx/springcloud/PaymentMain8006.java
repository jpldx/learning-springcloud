package com.jpldx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@EnableDiscoveryClient // 服务注册与发现
@SpringBootApplication(scanBasePackages = {"com.jpldx.springcloud"})
public class PaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class,args);
    }
}
