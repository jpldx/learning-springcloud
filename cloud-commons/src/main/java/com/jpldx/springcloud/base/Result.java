package com.jpldx.springcloud.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message) {
        this(code, message, null);
    }
}
