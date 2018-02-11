package by.gorodkevich.online.wallet.controller;

import by.gorodkevich.online.wallet.entity.UserEntity;
import by.gorodkevich.online.wallet.service.UserService;
import by.gorodkevich.online.wallet.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(CommonController.PATH + "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/updatePassword")
    public UserEntity updatePassword(@RequestBody UserVO userVO) {
        return userService.updatePassword(userVO);
    }

}
