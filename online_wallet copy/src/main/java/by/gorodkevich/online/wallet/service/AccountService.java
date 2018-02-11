package by.gorodkevich.online.wallet.service;


import by.gorodkevich.online.wallet.entity.AccountEntity;

import java.util.List;

public interface AccountService extends CommonService<AccountEntity> {

    AccountEntity createAccount();

    AccountEntity updateIsActiveForClient(long numberAccount);

    AccountEntity updateIsActiveForAdmin(long numberAccount, boolean status);

    AccountEntity findByNumber(long numberAccount);

    List<AccountEntity> getInfoList();
}
