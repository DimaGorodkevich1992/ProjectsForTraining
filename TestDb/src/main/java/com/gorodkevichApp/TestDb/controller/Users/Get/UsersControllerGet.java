package com.gorodkevichApp.TestDb.controller.Users.Get;

import com.gorodkevichApp.TestDb.services.UserServices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersControllerGet {
    @Autowired
    private UserServices userServices;



    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logOut() {
        userServices.userLogOut();
    }
}
