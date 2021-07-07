package com.adp.coins.controller;

import com.adp.coins.dto.Change;
import com.adp.coins.exception.CoinException;
import com.adp.coins.service.CoinCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CoinControllerTest {

    @Autowired
    private CoinController coinController;

    @Autowired
    private CoinCollection cc;

    @Test
    public void change_test_amount_1(){
        cc.setDefaultCoinMap();
        Change change = coinController.change(1).getBody().get(0);
        assertEquals(25, change.getCoin());
        assertEquals(4, change.getNumber());
    }

    @Test
    @Order(2)
    public void change_test_amount_5(){
        cc.setDefaultCoinMap();
        Change change = coinController.change(5).getBody().get(0);
        assertEquals(25, change.getCoin());
        assertEquals(20, change.getNumber());
    }



    @Test
    public void change_test_amount_10(){
        cc.setDefaultCoinMap();
        List<Change> change = coinController.change(10).getBody();
        Change change1 = change.get(0);
        assertEquals(25, change1.getCoin());
        assertEquals(40, change1.getNumber());
    }

    @Test
    public void change_test_amount_NoCoinException(){
        Assertions.assertThrows(CoinException.class,() ->  coinController.change(100).getBody());
    }

}
