package by.gorodkevich.app.service;

import by.gorodkevich.app.persistence.entity.HistoryEntity;
import by.gorodkevich.app.persistence.entity.TypeOperationEntity;
import java.util.List;

public interface HistoryService {

    void createHistory(TypeOperationEntity typeOperation, long accountId, double money);

    List<HistoryEntity> findByAccNumber(long accountNumber);

}
