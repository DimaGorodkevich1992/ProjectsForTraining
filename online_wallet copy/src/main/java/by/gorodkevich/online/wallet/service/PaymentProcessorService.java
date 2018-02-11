package by.gorodkevich.online.wallet.service;


import by.gorodkevich.online.wallet.vo.CheckAndRequestVO;
import by.gorodkevich.online.wallet.vo.ValidateVO;

/**
 * Класс для обработки платежей в интернет магазинах
 */
public interface PaymentProcessorService {

    /**
     *
     * @param checkAndRequest запрос на платеж и чек
     * внутри номера аккаунтов , сумма платежа и тип операции
     * @return
     */
    String requestToPay(CheckAndRequestVO checkAndRequest);

    /**
     *
     * @param validateVO класс где содержится токен и ключ для подтверждения пароля
     */
    void acceptPay(ValidateVO validateVO);
}
