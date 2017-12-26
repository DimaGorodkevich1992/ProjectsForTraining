package com.gorodkevichApp.TestDb.model.domain;

public class Account {

    private int accountNumber;
    private double accountMoney;

    public Account(int accountNumber, double accountMoney) {
        this.accountNumber = accountNumber;
        this.accountMoney = accountMoney;

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(double accountMoney) {
        this.accountMoney = accountMoney;
    }
}
