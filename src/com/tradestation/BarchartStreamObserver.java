package com.tradestation;

import com.tradestation.webapi.IntradayBar;

import java.util.Observable;
import java.util.Observer;

/**
 * @author jjelinek@tradestation.com
 */
class BarchartStreamObserver implements Observer {
    private final String symbol;

    public BarchartStreamObserver(String symbol) {
        this.symbol = symbol.toUpperCase();
    }

    @Override
    public void update(Observable obj, Object arg) {
        if (arg instanceof IntradayBar) {
            IntradayBar response = (IntradayBar) arg;
            System.out.println("Symbol: " + symbol + "\tDownTicks: " + response.getDownTicks()
                    + "\tTimeStamp: " + response.getTimeStamp());
        }
    }
}
