package by.gorodkevich.online.wallet.service.impl;


import by.gorodkevich.online.wallet.entity.AccountEntity;
import by.gorodkevich.online.wallet.repository.AccountRepository;
import by.gorodkevich.online.wallet.repository.TypeOperationRepository;
import by.gorodkevich.online.wallet.service.HistoryService;
import by.gorodkevich.online.wallet.service.IOMoneyInSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IOMoneyInSystemImpl implements IOMoneyInSystem {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TypeOperationRepository typeOperationRepository;
    @Autowired
    private HistoryService historyService;

    @Transactional
    @Override
    public void inputMoney(Long toAccountNumber, Integer amount) {
        AccountEntity account = accountRepository.findByNumber(toAccountNumber);
        account.setMoney(account.getMoney() + amount);
        accountRepository.save(account);


    }
}
