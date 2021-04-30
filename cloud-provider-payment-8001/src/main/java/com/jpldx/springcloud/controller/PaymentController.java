package com.jpldx.springcloud.controller;

import com.jpldx.springcloud.base.Result;
import com.jpldx.springcloud.entity.Payment;
import com.jpldx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public Result add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        if(result > 0){
            return new Result(200, "success!", result);
        }
        return new Result(500, "failed!", null);
    }

    @GetMapping("/get/{id}")
    public Result get(@PathVariable(name = "id") Long id){
        Payment result = paymentService.getById(id);
        if(result != null){
            return new Result(200, "success!", result);
        }
        return new Result(500, "failed!", null);
    }
}
