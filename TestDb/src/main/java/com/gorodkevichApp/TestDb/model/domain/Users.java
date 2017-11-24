package com.gorodkevichApp.TestDb.model.domain;

public class Users {
    private int userId;
    private String userName;
    private int userStatus;

    public Users(int idUser, String userName, int userStatus) {
        this.userId = idUser;
        this.userName = userName;
        this.userStatus = userStatus;
    }

    public int getIdUser() {
        return userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userNumber) {
        this.userStatus = userStatus;
    }
}



