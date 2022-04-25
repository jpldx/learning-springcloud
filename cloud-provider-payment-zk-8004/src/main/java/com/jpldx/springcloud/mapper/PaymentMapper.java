package com.jpldx.springcloud.mapper;

import com.jpldx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Mapper
public interface PaymentMapper {

    int add(@Param("payment") Payment payment);

    Payment getById(@Param("id") Long id);
}
