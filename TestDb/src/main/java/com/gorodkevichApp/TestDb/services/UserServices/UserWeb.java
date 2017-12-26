package com.gorodkevichApp.TestDb.services.UserServices;

public class UserWeb {
    private String oldPass;
    private String newPass;

    public UserWeb() {
    }

    public UserWeb(String oldPass, String newPass) {
        this.oldPass = oldPass;
        this.newPass = newPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }
}
