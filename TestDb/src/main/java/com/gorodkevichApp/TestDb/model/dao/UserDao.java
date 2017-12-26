package com.gorodkevichApp.TestDb.model.dao;

import com.gorodkevichApp.TestDb.model.domain.User;

public interface UserDao {

    void createUser(User user);

    void updatePassword(String carrentUserName, String oldPassword, String newPassword);

    String getPassword(String carrentUserName);

    //User loginUser(User users);

}
