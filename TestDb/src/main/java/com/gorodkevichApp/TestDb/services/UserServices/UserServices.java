package com.gorodkevichApp.TestDb.services.UserServices;

import com.gorodkevichApp.TestDb.model.dao.UserDao;
import com.gorodkevichApp.TestDb.model.daoImpl.JdbcConnect;
import com.gorodkevichApp.TestDb.model.daoImpl.UserDaoImpl;
import com.gorodkevichApp.TestDb.model.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    UserDao userDao = new UserDaoImpl(JdbcConnect.getInstance());

    private static String currentUserName = null;

    public static String getCurrentUserName() {
        return currentUserName;
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public boolean updateUsersPassword(UserWeb userWeb) {
        if (currentUserName != null) {
            userDao.updatePassword(currentUserName, userWeb.getOldPass(), userWeb.getNewPass());
            return true;
        } else return false;
    }

    public boolean loginUser(String name, String password) {
        String tmpPassword = userDao.getPassword(name);
        if (password.equals(tmpPassword)) {
            currentUserName = name;
            return true;
        } else return false;
    }

    public void userLogOut() {
        currentUserName = null;
    }
}
