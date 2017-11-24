package com.gorodkevichApp.TestDb.model.dao;

import com.gorodkevichApp.TestDb.model.domain.Users;

public interface UsersDao {
    Users getById(int id);

    void insertUser(Users user);

    void updateUser(Users user);


}
