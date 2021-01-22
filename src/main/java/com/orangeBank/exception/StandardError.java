package com.orangeBank.exception;

import lombok.Data;

@Data
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String message;


}
