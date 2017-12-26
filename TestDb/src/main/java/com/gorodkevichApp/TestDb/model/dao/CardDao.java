package com.gorodkevichApp.TestDb.model.dao;

public interface CardDao {

    void createCard(int cardNumber, String currentUserName) ;

    void updateStatus(int newCardNumber);

}
