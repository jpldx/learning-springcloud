package com.jpldx.springcloud.controller;

import com.jpldx.springcloud.base.Result;
import com.jpldx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public Result get(@PathVariable(name = "id") Long id) {
        return paymentFeignService.getById(id);
    }

}
