package com.ssysemployees.core.config.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthenticationException extends Exception{

    private String message;
    
}
