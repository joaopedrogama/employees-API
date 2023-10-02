package com.ssysemployees.core.config.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends Exception {

    private String message;
}
