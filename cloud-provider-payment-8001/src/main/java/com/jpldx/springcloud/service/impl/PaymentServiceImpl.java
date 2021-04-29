package com.jpldx.springcloud.service.impl;

import com.jpldx.springcloud.entity.Payment;
import com.jpldx.springcloud.mapper.PaymentMapper;
import com.jpldx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int add(Payment payment) {
        return paymentMapper.add(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentMapper.getById(id);
    }
}
