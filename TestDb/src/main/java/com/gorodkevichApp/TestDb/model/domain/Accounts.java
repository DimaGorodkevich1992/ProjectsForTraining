package com.gorodkevichApp.TestDb.model.domain;

public class Accounts {
    private int idAccounts;
    private int accountNumber;
    private int accountMoney;
    private int accountPassword;

    public int getAccountPassword() {
        return accountPassword;
    }

    public Accounts(int accountNumber, int accountMoney, int accountPassword) {
        this.accountNumber = accountNumber;
        this.accountMoney = accountMoney;
        this.accountPassword = accountPassword;
    }

    public void setAccountPassword(int accountPassword) {

        this.accountPassword = accountPassword;
    }

    public int getIdAccounts() {
        return idAccounts;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(int accountMoney) {
        this.accountMoney = accountMoney;
    }
}
