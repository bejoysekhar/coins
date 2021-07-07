package com.adp.coins.controller;

import com.adp.coins.exception.CoinException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class CoinControllerAdvice {

    @ExceptionHandler(value= {CoinException.class, ConstraintViolationException.class})
    public ResponseEntity<Object> handleExceptions(RuntimeException ex){

        return ResponseEntity.ok().body(ex.getMessage());

    }
}
