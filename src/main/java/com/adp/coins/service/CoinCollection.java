package com.adp.coins.service;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CoinCollection {

    private final Integer quarter = 25;
    private final Integer noOfQuarters = 100;
    private final Integer dime = 10;
    private final Integer noOfDimes = 100;
    private final Integer nickel = 5;
    private final Integer noOfNickels = 100;
    private final Integer penny = 1;
    private final Integer noOfPennys = 100;

    private Map<Integer, Integer> coinMap = new HashMap<>();

    public CoinCollection(){
        coinMap.put(quarter, noOfQuarters);
        coinMap.put(dime, noOfDimes);
        coinMap.put(nickel, noOfNickels);
        coinMap.put(penny, noOfPennys);
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

    public void overrideCoinMap(Integer noOfQuarters, Integer noOfDimes, Integer noOfNickels, Integer noOfPennys){
        coinMap.replace(quarter, noOfQuarters);
        coinMap.replace(dime, noOfDimes);
        coinMap.replace(nickel, noOfNickels);
        coinMap.replace(penny, noOfPennys);
    }

    public void setDefaultCoinMap(){
        coinMap.replace(quarter, noOfQuarters);
        coinMap.replace(dime, noOfDimes);
        coinMap.replace(nickel, noOfNickels);
        coinMap.replace(penny, noOfPennys);
    }


}
