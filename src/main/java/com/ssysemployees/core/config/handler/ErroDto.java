package com.ssysemployees.core.config.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErroDto {

    private String campo;
    private String message;
    
    public ErroDto(String message) {
        this.message = message;
    }
}
