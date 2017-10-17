package com.gorodkevichApp.Atm;

/**
 * Created by dima on 17.10.2017.
 */
public class Service implements MoneyOperations {
    Money money = new Money();

    @Override
    public void putMoney(int putValue) {
        money.cash += putValue;
        System.out.println("деньги зачислены , ваш баланс" + money.cash);
    }

    @Override
    public void takeMoney(int takeValue) {
        money.cash-= takeValue;
        System.out.println("сумма снята , ваш баланс " + money.cash);
    }


    @Override
    public int giveMyCardAccount() {
        return money.cash;
    }


}
