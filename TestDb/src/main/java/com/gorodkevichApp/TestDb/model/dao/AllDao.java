package com.gorodkevichApp.TestDb.model.dao;

public interface AllDao {
    AllDao get(int userNumber);

    void create(int numberUser, String name, boolean statusUser, char password, boolean statusAdmin);


}
