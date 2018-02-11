package by.gorodkevich.online.wallet.service;


import by.gorodkevich.online.wallet.entity.AccountEntity;
import by.gorodkevich.online.wallet.entity.HistoryEntity;
import by.gorodkevich.online.wallet.entity.TypeOperationEntity;

import java.util.List;

public interface HistoryService {

    void createHistory(long typeOperations, Long accountNumber, Integer money);

    List<HistoryEntity> findByAccNumber(long accountNumber);

}
