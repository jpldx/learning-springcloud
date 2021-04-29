package com.jpldx.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Data
public class Payment implements Serializable {

    private Long id;
    private String serial;
}
