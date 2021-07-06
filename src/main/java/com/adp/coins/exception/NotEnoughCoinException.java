package com.adp.coins.exception;

public class NotEnoughCoinException extends RuntimeException {

    public NotEnoughCoinException(String message){
        super(message);
    }
}
