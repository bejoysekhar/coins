package com.adp.coins.controller;

import com.adp.coins.dto.Change;
import com.adp.coins.service.CoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/coin")
public class CoinController {

    private CoinService coinService;

    public CoinController(CoinService coinService){
        this.coinService = coinService;
    }

    @GetMapping("/change")
    public ResponseEntity<List<Change>> change(@PathParam("amount") Integer amount){
        return ResponseEntity.ok().body(coinService.changeService(amount * 100));
    }
}
