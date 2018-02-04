package by.gorodkevich.app.service.serviceImpl;

import by.gorodkevich.app.persistence.entity.CheckEntity;
import by.gorodkevich.app.persistence.entity.RequestEntity;
import by.gorodkevich.app.persistence.entity.TokenEntity;
import by.gorodkevich.app.persistence.repository.*;
import by.gorodkevich.app.service.InternalMoneyTransferService;
import by.gorodkevich.app.service.PaymentProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PaymentProcessorServiceImpl implements PaymentProcessorService {
    @Autowired
    TypeOperationRepository typeOperationRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    CheckRepository checkRepository;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    InternalMoneyTransferService internalMoneyTransferService;

    /**
     * метод для генерации токена
     *
     * @return возвращает String
     */
    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    /**
     * метод для генерации уникального номера запроса
     *
     * @return возвращает номер int
     */
    private int uniqueNumberCreator() {
        int min = 1;
        int max = 2147483645;
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    @Transactional
    @Override
    public String requestToPay(RequestEntity requestForPay, CheckEntity paymentCheck) {
        int numberForRequest = uniqueNumberCreator();
        requestForPay.setUniqueNumber(numberForRequest);
        requestRepository.save(requestForPay);

        paymentCheck.setRequestEntity(requestRepository.findByUniqueNumber(numberForRequest));
        paymentCheck.setTypeOperationEntity(typeOperationRepository.findById(1));
        paymentCheck.setDateTime(OffsetDateTime.now());
        checkRepository.save(paymentCheck);

        TokenEntity tokenEntity = new TokenEntity();
        String token = generateToken();
        tokenEntity.setToken(token);
        tokenEntity.setActive(true);
        tokenEntity.setCheckEntity(checkRepository.findByRequestEntity_UniqueNumber(numberForRequest));
        tokenRepository.save(tokenEntity);

        return token;
    }

    @Transactional
    @Override
    public void acceptPay(String requestToPayToken) {
        if (tokenRepository.findByToken(requestToPayToken) == null) {  //поиск на соответстве токена
            System.out.println("неверный код подтверждения");
        } else if (tokenRepository.findByToken(requestToPayToken).getActive()) {
            TokenEntity wantedToken = tokenRepository.findByToken(requestToPayToken);       // поиск чека и запроса на платеж по токену
            CheckEntity wantedCheck = checkRepository.findById(wantedToken.getCheckEntity().getId());
            RequestEntity wantedRequest = requestRepository.findById(wantedCheck.getRequestEntity().getId());

            internalMoneyTransferService.move(wantedRequest, wantedCheck);
            //закрытие токена
            wantedToken.setActive(false);
            tokenRepository.save(wantedToken);
        } else System.out.println("этот токен уже использован");
    }
}
