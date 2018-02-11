package by.gorodkevich.online.wallet.service.impl;

import by.gorodkevich.online.wallet.entity.AccountEntity;
import by.gorodkevich.online.wallet.repository.AccountRepository;
import by.gorodkevich.online.wallet.repository.TypeOperationRepository;
import by.gorodkevich.online.wallet.service.HistoryService;
import by.gorodkevich.online.wallet.service.InternalMoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InternalMoneyTransferServiceImpl implements InternalMoneyTransferService {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private AccountRepository accountRepository;




    @Transactional
    @Override
    public void move(Long toAccountNumber, Long fromAccountNumber, Integer moneyAmount) {
        AccountEntity toAccNumber = accountRepository.findByNumber(toAccountNumber);
        AccountEntity fromAccNumber = accountRepository.findByNumber(fromAccountNumber);
        if (fromAccNumber.getMoney() >= moneyAmount) {
            fromAccNumber.setMoney(fromAccNumber.getMoney() - moneyAmount);
            accountRepository.save(fromAccNumber);
            historyService.createHistory(1, fromAccountNumber, moneyAmount);

            toAccNumber.setMoney(toAccNumber.getMoney() + moneyAmount);
            accountRepository.save(toAccNumber);
            historyService.createHistory(2, toAccountNumber, moneyAmount);
        }else throw new IllegalArgumentException();


    }
}
