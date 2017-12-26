package com.gorodkevichApp.TestDb.model.daoImpl;

import com.gorodkevichApp.TestDb.model.dao.AccountDao;
import com.gorodkevichApp.TestDb.model.domain.Account;

public class AccountDaoImpl implements AccountDao {
    private static JdbcConnect connect;

    public AccountDaoImpl(JdbcConnect connect) {
        this.connect = connect;
    }

    @Override
    public void createAccount(Account account, int numberCard) {

    }

    @Override
    public double getMoney(int accountNumber) {
        return 0;
    }

    @Override
    public void updateMoney(int accountNumber, double money) {

    }

    @Override
    public void updateStatus(int accountNumber, boolean status) {

    }
}
