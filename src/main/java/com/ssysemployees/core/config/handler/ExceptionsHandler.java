package com.ssysemployees.core.config.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class ExceptionsHandler {

    private MessageSource messageSource; //Classe que auxilia na tradução de idiomas
    
    //Função que é chamada para tratameto de exceptions
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) //Devolve uma BAD REQUEST
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDto> handle(MethodArgumentNotValidException exception) {

        List<ErroDto> dto = new ArrayList<>();
        List<FieldError> fielderros =  exception.getBindingResult().getFieldErrors();

        fielderros.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDto erro = new ErroDto(e.getField(), mensagem);
            dto.add(erro);
        });

        return dto;

    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServiceException.class)
    public ErroDto handleValidcaoException(ServiceException exception) {
        return new ErroDto(exception.getMessage());
    }
}