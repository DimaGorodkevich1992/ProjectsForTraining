package by.gorodkevich.app.service;

import by.gorodkevich.app.persistence.entity.AccountEntity;

import java.util.List;

public interface AccountService {

    void addAccount();

    void updateIsActiveForClient(long numberAccount);

    void updateIsActiveForAdmin(long numberAccount, boolean status);

    AccountEntity findByNumber(long numberAccount);

    List<AccountEntity> findInfoList(String clientName);
}
