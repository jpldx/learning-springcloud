package com.jpldx.springcloud.service;

import com.jpldx.springcloud.entity.Payment;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
public interface PaymentService {

    int add(Payment payment);

    Payment getById(Long id);
}
