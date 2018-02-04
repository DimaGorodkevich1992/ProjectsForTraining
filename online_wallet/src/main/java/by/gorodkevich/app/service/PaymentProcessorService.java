package by.gorodkevich.app.service;


import by.gorodkevich.app.persistence.entity.CheckEntity;
import by.gorodkevich.app.persistence.entity.RequestEntity;

/**
 * Класс для обработки платежей в интернет магазинах
 */
public interface PaymentProcessorService {

    /**
     * Запрос оплаты
     * @param paymentCheck чек за услугу
     * @param requestForPay запрос на оплату
     * @return токен запроса
     */
    String requestToPay(RequestEntity requestForPay, CheckEntity paymentCheck);

    /**
     * Потверждение оплаты
     * @param requestToPayToken токен запроса оплаты
     */
    void acceptPay(String requestToPayToken);
}
