package com.adp.coins.service;

import com.adp.coins.dto.Change;
import com.adp.coins.exception.CoinException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoinServiceTest {

    @Autowired
    private CoinService coinService;

    @Autowired
    private CoinCollection cc;

    @Test
    public void change_test_amount_1(){
        Assertions.assertThrows(CoinException.class, () -> coinService.changeService(1));
    }


    @Test
    public void change_test_amount_41(){
        cc.setDefaultCoinMap();
        List<Change> changeList = coinService.changeService(4100);
        assertEquals(25, changeList.get(0).getCoin());
        assertEquals(100, changeList.get(0).getNumber());
        assertEquals(10, changeList.get(1).getCoin());
        assertEquals(100, changeList.get(1).getNumber());
        assertEquals(5, changeList.get(2).getCoin());
        assertEquals(100, changeList.get(2).getNumber());
        assertEquals(1, changeList.get(3).getCoin());
        assertEquals(100, changeList.get(3).getNumber());
    }


    @Test
    public void change_test_amount_42(){
        Assertions.assertThrows(CoinException.class, () -> coinService.changeService(4200));
    }

}
