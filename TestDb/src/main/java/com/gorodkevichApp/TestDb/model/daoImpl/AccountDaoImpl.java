package com.gorodkevichApp.TestDb.model.daoImpl;

import com.gorodkevichApp.TestDb.model.dao.AccountDao;
import com.gorodkevichApp.TestDb.model.domain.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    private JdbcConnect connect;

    public AccountDaoImpl(JdbcConnect connect) {
        this.connect = connect;
    }

    @Override
    public void set(Account account) {
        String SQLSet = "INSERT INTO account (account_number, account_money)VALUES (?,?)";
        int number = account.getAccountNumber();
        double money = account.getAccountMoney();
        try (Connection connection = connect.getConnection();
             PreparedStatement prst = connection.prepareStatement(SQLSet)) {
            prst.setInt(1, number);
            prst.setDouble(2, money);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setMoney(int accNumber, int ammount) {
        String SQLSet = "UPDATE  account SET account_money = ? WHERE account_number = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement prst = connection.prepareStatement(SQLSet)) {
            prst.setDouble(1, ammount);
            prst.setInt(2,accNumber);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getMoney(int accNumber) {
        return 0;
    }

    @Override
    public void updateStatusUser(int cadNumber) {

    }

    @Override
    public void updateStatusAdmin(int cardNumber, boolean status) {

    }
}
