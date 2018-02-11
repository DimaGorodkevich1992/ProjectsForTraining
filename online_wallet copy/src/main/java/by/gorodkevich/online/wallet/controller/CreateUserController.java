package by.gorodkevich.online.wallet.controller;

import by.gorodkevich.online.wallet.entity.UserEntity;
import by.gorodkevich.online.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/create")
public class CreateUserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity newUser){
        return userService.createUser(newUser);
    }
}
