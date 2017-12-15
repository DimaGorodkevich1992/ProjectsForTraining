package com.gorodkevichApp.TestDb.model.dao;

import com.gorodkevichApp.TestDb.model.domain.Account;

public interface AccountDao {
    void set(Account account);

    void putMoney(int accNumber,int ammount);

    int getMoney(int accNumber);

    void updateStatusUser(int cadNumber);

    void updateStatusAdmin(int cardNumber, boolean status);

}
