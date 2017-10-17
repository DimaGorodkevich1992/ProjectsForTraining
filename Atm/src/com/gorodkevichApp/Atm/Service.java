package com.gorodkevichApp.Atm;

/**
 * Created by dima on 17.10.2017.
 */
public class Service implements ModelMoney {
    Money money = new Money();


    @Override
    public void putMoney(int putValue) {
        money.cash += putValue;
    }

    @Override
    public void takeMoney(int takeValue) {
        money.bunknoteValue.add(5);
        money.bunknoteValue.add(10);
        money.bunknoteValue.add(15);
        if (takeValue > money.cash) {
            System.out.println("Введенная вами сумма превышает ваш баланс , баланс вашего счета " + money.cash);
        }
        for (int index : money.bunknoteValue) {
            if (takeValue % index == 0) {
                money.cash -= takeValue;
            }
            System.out.println("Неверно введена сумма для выдачи имеются купюры 5, 10, 15");
        }

    }


    @Override
    public int giveMyCardAccount() {
        return money.cash;
    }


}
