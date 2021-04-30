package com.jpldx.springcloud.controller;

import com.jpldx.springcloud.base.Result;
import com.jpldx.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_SERVICE_URL = "http://localhost:8001";

    @PostMapping("/payment/add")
    public Result add(Payment payment){
        return restTemplate.postForObject(PAYMENT_SERVICE_URL + "/payment/add", payment, Result.class);
    }

    @GetMapping("/payment/get/{id}")
    public Result get(@PathVariable(name = "id")Long id){
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/payment/get/" + id, Result.class);
    }
}
