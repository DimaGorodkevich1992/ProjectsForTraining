package by.gorodkevich.app.service;

/**
 * Ввод/вывод денег в системе
 */
public interface IOMoneyInSystem {

    void inputMoney(Long toAccountNumber, Double amount);
}
