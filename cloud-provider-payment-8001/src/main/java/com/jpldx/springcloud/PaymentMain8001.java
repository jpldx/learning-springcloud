package com.jpldx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@SpringBootApplication(scanBasePackages = {"com.jpldx.springcloud"})
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
