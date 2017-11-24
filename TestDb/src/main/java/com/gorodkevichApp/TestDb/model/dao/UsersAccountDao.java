package com.gorodkevichApp.TestDb.model.dao;

import com.gorodkevichApp.TestDb.model.domain.UserAccounts;

import java.util.List;

public interface UsersAccountDao {
    List<UserAccounts> getAllColumn();
}
