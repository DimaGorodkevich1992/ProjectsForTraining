package com.gorodkevichApp.TestDb.model;

import com.gorodkevichApp.TestDb.model.dao.UsersDao;
import com.gorodkevichApp.TestDb.model.daoImpl.JdbcConnect;
import com.gorodkevichApp.TestDb.model.daoImpl.UserDaoImpl;

public class Main {
    private static UsersDao usersDao = new UserDaoImpl(JdbcConnect.getInstance());

    public static void main(String[] args) {
        usersDao.getById(3);
    }

}
