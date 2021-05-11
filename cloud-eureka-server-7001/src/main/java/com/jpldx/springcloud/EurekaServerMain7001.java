package com.jpldx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@EnableEurekaServer // 开启Eureka服务端
@SpringBootApplication
public class EurekaServerMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7001.class, args);
    }
}
