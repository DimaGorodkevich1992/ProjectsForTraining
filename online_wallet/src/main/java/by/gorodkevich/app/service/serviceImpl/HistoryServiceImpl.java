package by.gorodkevich.app.service.serviceImpl;

import by.gorodkevich.app.persistence.entity.HistoryEntity;
import by.gorodkevich.app.persistence.entity.TypeOperationEntity;
import by.gorodkevich.app.persistence.repository.*;
import by.gorodkevich.app.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
@Service
public class HistoryServiceImpl implements HistoryService {
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
    @Override
    public void createHistory(TypeOperationEntity typeOperation, long accountId, double money) {
        HistoryEntity historyForClient = new HistoryEntity();
        historyForClient.setAccountEntity(accountRepository.findByNumber(accountId));
        historyForClient.setMoney(money);
        historyForClient.setTypeOperationEntity(typeOperation);
        historyForClient.setDateTime(OffsetDateTime.now());
        historyRepository.save(historyForClient);
    }

    @Override
    public List<HistoryEntity> findByAccNumber(long accountNumber) {
        return historyRepository.findByAccountEntity_Number(accountNumber);
    }
}
