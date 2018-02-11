package by.gorodkevich.online.wallet.service;


/**
 * Класс для перемещения денег внутри системы*/
public interface InternalMoneyTransferService {
    /**
     *
     * @param toAccountNumber номер аккаунта куда переводить деньги
     * @param fromAccountNumber номер аккаунта с которого нужно перевести деньги
     * @param moneyAmount денежная сумма
     */
    void move(Long toAccountNumber, Long fromAccountNumber, Integer moneyAmount);

}
