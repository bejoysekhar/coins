package com.adp.coins.controller;

import com.adp.coins.exception.NotEnoughCoinException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CoinControllerAdvice {

    @ExceptionHandler(value= NotEnoughCoinException.class)
    public ResponseEntity<Object> handleExceptions(RuntimeException ex){

        return ResponseEntity.ok().body(ex.getMessage());

    }
}
