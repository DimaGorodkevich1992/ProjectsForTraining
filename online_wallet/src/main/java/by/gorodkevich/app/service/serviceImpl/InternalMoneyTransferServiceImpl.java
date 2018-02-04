package by.gorodkevich.app.service.serviceImpl;

import by.gorodkevich.app.persistence.entity.AccountEntity;
import by.gorodkevich.app.persistence.entity.CheckEntity;
import by.gorodkevich.app.persistence.entity.HistoryEntity;
import by.gorodkevich.app.persistence.entity.RequestEntity;
import by.gorodkevich.app.persistence.repository.*;
import by.gorodkevich.app.service.HistoryService;
import by.gorodkevich.app.service.InternalMoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class InternalMoneyTransferServiceImpl implements InternalMoneyTransferService {
    @Autowired
    HistoryService historyService;
    @Autowired
    TypeOperationRepository typeOperationRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    TokenRepository tokenRepository;

    @Transactional
    @Override
    public void move(RequestEntity requestForMove, CheckEntity checkForMove) {
        AccountEntity payer = accountRepository.findByNumber(requestForMove.getFromAccNumber());
        AccountEntity recipient = accountRepository.findByNumber(requestForMove.getToAccNumber());
        payer.setMoney(payer.getMoney() - checkForMove.getMoney());
        recipient.setMoney(recipient.getMoney() + checkForMove.getMoney());
        accountRepository.save(payer);
        accountRepository.save(recipient);


        historyService.createHistory(checkForMove.getTypeOperationEntity(), requestForMove.getFromAccNumber(), checkForMove.getMoney());

        historyService.createHistory(typeOperationRepository.findById(2), requestForMove.getToAccNumber(), checkForMove.getMoney());


    }
}
