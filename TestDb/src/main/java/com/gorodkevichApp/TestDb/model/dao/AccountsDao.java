package com.gorodkevichApp.TestDb.model.dao;

import com.gorodkevichApp.TestDb.model.domain.Accounts;

public interface AccountsDao {
    Accounts getById(int user_id);

    void insertAccount(Accounts account);

    void updateAccount(Accounts account);



}
