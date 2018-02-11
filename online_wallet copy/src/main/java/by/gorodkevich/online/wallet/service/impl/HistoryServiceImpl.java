package by.gorodkevich.online.wallet.service.impl;


import by.gorodkevich.online.wallet.entity.HistoryEntity;
import by.gorodkevich.online.wallet.repository.AccountRepository;

import by.gorodkevich.online.wallet.repository.HistoryRepository;
import by.gorodkevich.online.wallet.repository.TypeOperationRepository;
import by.gorodkevich.online.wallet.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class HistoryServiceImpl extends CommonServiceImpl<HistoryEntity> implements HistoryService {

    @Autowired
    private TypeOperationRepository typeOperationRepository;
    @Autowired
    private AccountRepository accountRepository;

    private HistoryRepository repository;


    @Autowired
    public HistoryServiceImpl(HistoryRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    public void createHistory(long typeOperations, Long accountNumber, Integer money) {
        HistoryEntity newHistory = new HistoryEntity();
        newHistory.setAccountEntity(accountRepository.findByNumber(accountNumber));
        newHistory.setMoney(money);
        newHistory.setTypeOperationEntity(typeOperationRepository.findById(typeOperations));
        newHistory.setDateTime(OffsetDateTime.now());
        repository.save(newHistory);

    }

    @Override
    public List<HistoryEntity> findByAccNumber(long accountNumber) {
        return repository.findByAccountEntity_Number(accountNumber);
    }
}
