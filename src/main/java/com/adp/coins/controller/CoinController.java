package com.adp.coins.controller;

import com.adp.coins.dto.Change;
import com.adp.coins.service.CoinService;
import com.adp.coins.validator.AmountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Validator;
import java.util.List;

@RestController
@RequestMapping("/coin")
@Validated
public class CoinController {

    private CoinService coinService;

    public CoinController(CoinService coinService){
        this.coinService = coinService;
    }

    @GetMapping(value = "/change")
    public ResponseEntity<List<Change>> change(@RequestParam("amount") @AmountValidator(values = {"1","2","5","10","20","50","100"}) Integer amount){
        return ResponseEntity.ok().body(coinService.changeService(amount * 100));
    }

}
