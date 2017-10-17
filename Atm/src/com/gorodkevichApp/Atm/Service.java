package com.gorodkevichApp.Atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dima on 17.10.2017.
 */
public class Service implements MoneyOperations {
    Money money = new Money();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void putMoney(int putValue) {
        money.cash += putValue;
        System.out.println("деньги зачислены , ваш баланс" + money.cash);
    }

    @Override
    public void takeMoney() throws IOException {
        System.out.print("введите сумму : ");
        boolean identifier = false;

        while (!identifier) {
            int takeValue = Integer.parseInt(bufferedReader.readLine());
            if (takeValue > money.cash) {
                System.out.print("Введенная вами сумма превышает ваш баланс , баланс вашего счета " + money.cash + " введите сумму : ");
                continue;
            }

            int size = AtmConfig.getBanknotes().size();
            for (int index = 0; index < size; index++) {
                if (takeValue % AtmConfig.getBanknotes().get(index) == 0) {
                    money.cash -= takeValue;
                    identifier = true;
                    System.out.println("сумма снята , ваш баланс " + money.cash);
                    break;
                } else if (index == size - 1) {
                    System.out.print("Вы ввели не корректную сумму , банкомат выдает купюры 5, 10, 20" + " введите сумму : ");
                    continue;
                }
            }
        }

    }


    @Override
    public int giveMyCardAccount() {
        return money.cash;
    }


}
