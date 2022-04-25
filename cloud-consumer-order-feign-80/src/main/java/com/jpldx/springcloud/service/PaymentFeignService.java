package com.jpldx.springcloud.service;

import com.jpldx.springcloud.base.Result;
import com.jpldx.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
//@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


    @GetMapping("/payment/get/{id}")
    Result<Payment> getById(@PathVariable(name = "id") Long id);

}
