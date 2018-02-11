package by.gorodkevich.online.wallet.service;

/**
 * Ввод/вывод денег в системе
 */
public interface IOMoneyInSystem {

    void inputMoney(Long toAccountNumber, Integer amountMoney);
}
