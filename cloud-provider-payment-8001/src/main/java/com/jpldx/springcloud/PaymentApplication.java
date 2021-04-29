package com.jpldx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@SpringBootApplication(scanBasePackages = {"com.jpldx.springcloud"})
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class,args);
    }
}
