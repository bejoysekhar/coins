package com.adp.coins.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoinServiceTest {

    @Autowired
    private CoinService coinService;


    @Test
    public void coinServiceTest(){
        assertEquals(0, coinService.changeService(100));

    }
}
