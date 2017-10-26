package com.gorodkevichApp.Atm;

/**
 * Created by dima on 17.10.2017.
 */
public class Service implements MoneyOperations {
    Money money = new Money();

    @Override
    public void putMoney(int putValue) {
        money.setCash(money.getCash()+ putValue);
        System.out.println("Money trasfered your balance " + money.getCash());
    }

    @Override
    public boolean takeMoney(int takeValue) {
        boolean point = false;
        int numberOfBanknotes = AtmConfig.getBanknotes().size();
        for (int index = 0; index < numberOfBanknotes; index++) {
            if (takeValue % AtmConfig.getBanknotes().get(index) == 0) {
                money.setCash(money.getCash()- takeValue);
                System.out.println("Money trasfered your balance " + money.getCash());
                point = true;
                break;
            } else if (index == numberOfBanknotes - 1) {
                System.out.print("Wrong money amount , ATM has bank notes 5, 10, 20\" + \" enter money amount : ");
                break;
            }
        }
        return point;
    }

    @Override
    public int giveMyCardAccount() {
        return money.getCash();
    }


}
