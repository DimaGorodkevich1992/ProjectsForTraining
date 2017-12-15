package com.gorodkevichApp.TestDb.model;

import com.gorodkevichApp.TestDb.model.dao.AccountDao;
import com.gorodkevichApp.TestDb.model.dao.UsersDao;
import com.gorodkevichApp.TestDb.model.daoImpl.AccountDaoImpl;
import com.gorodkevichApp.TestDb.model.daoImpl.JdbcConnect;
import com.gorodkevichApp.TestDb.model.daoImpl.UsersDaoImpl;

public class Main {

    private static UsersDao usersDao;
    private static AccountDao accountDao;

    static {
        usersDao = new UsersDaoImpl(JdbcConnect.getInstance());
        accountDao = new AccountDaoImpl(JdbcConnect.getInstance());
    }

    public static void main(String[] args) {
        // usersDao.set(new Users("Usia","3sff34"));
        //usersDao.updateStatus("Dima");
        //usersDao.updatePassword("Usia", "3sff34", "qwerty");
        //accountDao.set(new Account(1235,434243.45));


    }
}



