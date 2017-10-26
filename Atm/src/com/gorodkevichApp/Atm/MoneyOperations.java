package com.gorodkevichApp.Atm;

import java.io.IOException;

/**
 * Created by dima on 17.10.2017.
 */
public interface MoneyOperations {

    void putMoney(int putValue);

    boolean takeMoney(int takeValue);

    int giveMyCardAccount();




}
