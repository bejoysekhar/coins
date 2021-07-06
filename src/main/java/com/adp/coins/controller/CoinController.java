package com.adp.coins.controller;

import com.adp.coins.dto.Change;
import com.adp.coins.service.CoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/v1/coin")
public class CoinController {

    private CoinService coinService;

    public CoinController(CoinService coinService){
        this.coinService = coinService;
    }

    @GetMapping("/change/{amount}")
    public List<Change> change(@PathParam("amount") Integer amount){
        return coinService.changeService(amount * 100);
    }
}
