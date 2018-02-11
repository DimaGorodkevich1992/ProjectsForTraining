package by.gorodkevich.online.wallet.service.impl;


import by.gorodkevich.online.wallet.entity.ChequeEntity;
import by.gorodkevich.online.wallet.entity.RequestEntity;
import by.gorodkevich.online.wallet.entity.ValidateEntity;
import by.gorodkevich.online.wallet.repository.ChequeRepository;
import by.gorodkevich.online.wallet.repository.RequestRepository;
import by.gorodkevich.online.wallet.repository.TypeOperationRepository;
import by.gorodkevich.online.wallet.repository.ValidateRepository;
import by.gorodkevich.online.wallet.service.InternalMoneyTransferService;
import by.gorodkevich.online.wallet.service.PaymentProcessorService;
import by.gorodkevich.online.wallet.vo.CheckAndRequestVO;
import by.gorodkevich.online.wallet.vo.ValidateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PaymentProcessorServiceImpl implements PaymentProcessorService {
    @Autowired
    private TypeOperationRepository typeOperationRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private ChequeRepository checkRepository;
    @Autowired
    private ValidateRepository validateRepository;
    @Autowired
    private InternalMoneyTransferService internalMoneyTransferService;

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
    private long uniqueNumberCreator() {
        Long min = 100000000000L;
        Long max = 999999999999L;
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    @Transactional
    @Override
    public String requestToPay(CheckAndRequestVO checkAndRequest) {
        String token = generateToken();
        ValidateEntity newValidate = new ValidateEntity();
        newValidate.setToken(token);
        newValidate.setKey(uniqueNumberCreator());
        newValidate.setActive(true);
        validateRepository.save(newValidate);       //сохранение токена и ключа

        ValidateEntity currentValidate = validateRepository.findByToken(token); //только что записанный токен

        RequestEntity newRequest = new RequestEntity();
        newRequest.setFromAccNumber(checkAndRequest.getFromAccountNumber());
        newRequest.setToAccNumber(checkAndRequest.getToAccountNumber());
        newRequest.setValidateEntity(currentValidate);
        requestRepository.save(newRequest);     //сохранение запроса

        long a = checkAndRequest.getTypeOperation();
        ChequeEntity newCheck = new ChequeEntity();
        newCheck.setMoney(checkAndRequest.getMoneyAmount());
        newCheck.setTypeOperationEntity(typeOperationRepository.findById(a));
        newCheck.setValidateEntity(currentValidate);
        newCheck.setDateTime(OffsetDateTime.now());
        checkRepository.save(newCheck);         //сохранение чека
        return token;
    }

    @Transactional
    @Override
    public void acceptPay(ValidateVO validateVO) {
        ValidateEntity wantedValidate = validateRepository.findByTokenAndKey(validateVO.getToken(), validateVO.getKey());
        if (wantedValidate != null) {
            if (wantedValidate.getActive()) {
                RequestEntity requestByValidate = requestRepository.findByValidateEntity(wantedValidate);
                ChequeEntity checkByValidate = checkRepository.findByValidateEntity(wantedValidate);

                internalMoneyTransferService.move(requestByValidate.getToAccNumber(),
                        requestByValidate.getFromAccNumber(), checkByValidate.getMoney());

                wantedValidate.setActive(false);
                validateRepository.save(wantedValidate);

            } else throw new IllegalArgumentException();

        } else throw new IllegalArgumentException();


    }
}
