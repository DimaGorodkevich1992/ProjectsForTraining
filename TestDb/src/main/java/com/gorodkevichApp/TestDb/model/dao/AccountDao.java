package com.gorodkevichApp.TestDb.model.dao;

import com.gorodkevichApp.TestDb.model.domain.Account;

public interface AccountDao {

    void createAccount(Account account, int numberCard);

    double getMoney(int accountNumber);

    void updateMoney(int accountNumber , double money);

    void updateStatus(int accountNumber , boolean status);






}
