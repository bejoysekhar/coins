package com.adp.coins.service;

import com.adp.coins.dto.Change;
import com.adp.coins.exception.NotEnoughCoinException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoinService {

    @Autowired
    CoinCollection cc;

    public List<Change> changeService(Integer amount){
        List<Change> changeList = new ArrayList<>();

        while(amount > 0){
            Integer highestCoin = 0;
            Integer coinsLeft=0;
            if((highestCoin = cc.getHighestCoinLeft()) > 0) {
                Integer noOfCoinsRequired = amount / highestCoin;
                if((coinsLeft = cc.reduceNumberOfCoins(highestCoin, noOfCoinsRequired)) >=0){
                    changeList.add(new Change(highestCoin, noOfCoinsRequired));
                    amount = amount % highestCoin;
                }else{
                    coinsLeft = Math.abs(coinsLeft);
                    changeList.add(new Change(highestCoin, noOfCoinsRequired - coinsLeft));
                    amount = highestCoin * coinsLeft;
                }
            }else{
                throw new NotEnoughCoinException("Not Enough Coin");
            }
        }



        return changeList;

    }

}
