package by.gorodkevich.online.wallet.repository;


import by.gorodkevich.online.wallet.entity.HistoryEntity;

import java.util.List;


public interface HistoryRepository extends CommonRepository<HistoryEntity> {

    //read
    List<HistoryEntity> findByAccountEntity_Number(long number);
}
