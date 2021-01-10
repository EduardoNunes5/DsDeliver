package com.br.estudos.dsdeliever.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> errors.add(String.format("campo %s", fieldError.getDefaultMessage())));

        return buildResponseEntity(HttpStatus.BAD_REQUEST, "Algum campo não selecionado", errors);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST,
                "Erro na formatação do json ou campo invalido", Collections.singletonList(ex.getLocalizedMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message, List<String> errors){
        ExceptionModel error = new ExceptionModel.Builder()
                .setCode(status.value())
                .setMessage(message)
                .setErrors(errors)
                .setStatus(status.getReasonPhrase())
                .setTimestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(error, status);
    }
}
