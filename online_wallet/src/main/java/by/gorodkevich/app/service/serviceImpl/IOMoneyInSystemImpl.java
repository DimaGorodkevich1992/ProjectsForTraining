package by.gorodkevich.app.service.serviceImpl;

import by.gorodkevich.app.persistence.entity.AccountEntity;
import by.gorodkevich.app.persistence.repository.AccountRepository;
import by.gorodkevich.app.persistence.repository.TypeOperationRepository;
import by.gorodkevich.app.service.HistoryService;
import by.gorodkevich.app.service.IOMoneyInSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IOMoneyInSystemImpl implements IOMoneyInSystem {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TypeOperationRepository typeOperationRepository;
    @Autowired
    HistoryService historyService;

    @Transactional
    @Override
    public void inputMoney(Long toAccountNumber, Double amount) {
        AccountEntity account = accountRepository.findByNumber(toAccountNumber);
        account.setMoney(account.getMoney() + amount);
        accountRepository.save(account);

        historyService.createHistory(typeOperationRepository.findById(2),toAccountNumber,amount);
    }
}
