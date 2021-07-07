package com.adp.coins.controller;

import com.adp.coins.dto.Change;
import com.adp.coins.exception.NotEnoughCoinException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CoinControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;



//    @Test
//    public void testController(){
////        List<Change> response = restTemplate
////                .getForEntity("http://localhost:" + port + "/cc/coin/change?amount=100", (Class<List<Change>>)(Object)List.class );
//
//        Change response = restTemplate
//                .getForObject("http://localhost:" + port + "/cc/coin/change?amount=100", Change.class );
//        System.out.println(response);
//    }

    @Autowired
    CoinController coinController;

    @Test
    @Order(1)
    public void change_test_amount_1(){
        Change change = coinController.change(1).getBody().get(0);
        assertEquals(25, change.getCoin());
        assertEquals(4, change.getNumber());
    }

    @Test
    @Order(2)
    public void change_test_amount_24(){
        Change change = coinController.change(24).getBody().get(0);
        assertEquals(25, change.getCoin());
        assertEquals(96, change.getNumber());
    }


    @Test
    @Order(3)
    public void change_test_amount_2(){
        Change change = coinController.change(2).getBody().get(0);
        assertEquals(10, change.getCoin());
        assertEquals(20, change.getNumber());
    }

    @Test
    @Order(4)
    public void change_test_amount_10(){
        List<Change> change = coinController.change(10).getBody();
        Change change1 = change.get(0);
        Change change2 = change.get(1);
        assertEquals(10, change1.getCoin());
        assertEquals(80, change1.getNumber());
        assertEquals(5, change2.getCoin());
        assertEquals(40, change2.getNumber());
    }

    @Test
    @Order(5)
    public void change_test_amount_NoCoinException(){
        Assertions.assertThrows(NotEnoughCoinException.class,() ->  coinController.change(100).getBody());
    }

}
