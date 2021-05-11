package com.jpldx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.jpldx.springcloud"})
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
