package com.gorodkevichApp.TestDb.controller.Users.Post;

import com.gorodkevichApp.TestDb.model.domain.User;
import com.gorodkevichApp.TestDb.services.UserServices.UserWeb;
import com.gorodkevichApp.TestDb.services.UserServices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersControllerPost {
    @Autowired
    private UserServices userServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUsers(@RequestBody User user) {
        userServices.createUser(user);
    }

    @RequestMapping(value = "/login/updatePassword", method = RequestMethod.PUT)
    public boolean updateUserPassword(@RequestBody UserWeb userWeb) {
        if (userServices.updateUsersPassword(userWeb)) {
            return true;
        } else return false;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean loginUser(@RequestBody User user) {
        if (userServices.loginUser(user.getUserName(), user.getUserPassword())) {
            return true;
        } else return false;
    }
}

