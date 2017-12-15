package com.gorodkevichApp.TestDb.model.dao;

import com.gorodkevichApp.TestDb.model.domain.Users;

public interface UsersDao {

    Users getForUsers(String name);

    void create(Users users);

    void updatePassword(String name, String newPassword);

    void updateStatus(String name);

}
