package by.gorodkevich.online.wallet.security;

import by.gorodkevich.online.wallet.entity.UserEntity;
import by.gorodkevich.online.wallet.service.CurrentUserService;
import by.gorodkevich.online.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Autowired
    private UserService userService;

    @Override
    public UserEntity get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return userService.findByEmail(email);
    }
}
