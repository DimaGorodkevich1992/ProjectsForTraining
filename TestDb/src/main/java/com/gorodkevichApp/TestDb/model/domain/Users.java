package com.gorodkevichApp.TestDb.model.domain;

public class Users {
    private String usersName;
    private String usersPassword;
    private boolean usersStatus;

    public Users(String usersName, boolean usersStatus) {
        this.usersName = usersName;
        this.usersStatus = usersStatus;
    }

    public Users(String usersName, String usersPassword) {
        this.usersName = usersName;
        this.usersPassword = usersPassword;
    }

    public String getUsersName() {
        return usersName;
    }


    public String getUsersPassword() {
        return usersPassword;
    }


    public boolean isUsersStatus() {
        return usersStatus;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public void setUsersPassword(String usersPassword) {
        this.usersPassword = usersPassword;
    }
}
