package com.adp.coins.service;

import com.adp.coins.dto.Change;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CoinCollection {

    private static final Integer quarter = 25;
    private static final Integer noQuarter = 100;
    private static final Integer dime = 10;
    private static final Integer noDime = 100;
    private static final Integer nickel = 5;
    private static final Integer noNickel = 100;
    private static final Integer penny = 1;
    private static final Integer noPenny = 100;

    private static Map<Integer, Integer> coinMap = new HashMap<>();

    static {
        coinMap.put(quarter, noQuarter);
        coinMap.put(dime, noDime);
        coinMap.put(nickel, noNickel);
        coinMap.put(penny, noPenny);

    }


    public Integer getHighestCoinLeft() {
        if(coinMap.get(quarter) > 0){
            return quarter;
        }
        if(coinMap.get(dime) > 0){
            return dime;
        }
        if(coinMap.get(nickel) > 0){
            return nickel;
        }
        if(coinMap.get(penny) > 0){
            return penny;
        }

        return 0;
    }

    public Integer getNumberOfCoinsLeft(Double coinType) {
        return coinMap.get(coinType);
    }

    public Integer reduceNumberOfCoins(Integer coinType, Integer noOfCoins) {
        Integer noOfCoinsLeft = coinMap.get(coinType) - noOfCoins;
        if (noOfCoinsLeft < 0){
            coinMap.replace(coinType, 0);
        }else {
            coinMap.replace(coinType, noOfCoinsLeft);
        }
        return noOfCoinsLeft;

    }

}
