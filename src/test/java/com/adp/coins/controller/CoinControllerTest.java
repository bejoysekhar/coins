package com.adp.coins.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;


@SpringBootTest
public class CoinControllerTest {

    @Test
    public void testCoinChange(){
        System.out.println("test");
    }

}
