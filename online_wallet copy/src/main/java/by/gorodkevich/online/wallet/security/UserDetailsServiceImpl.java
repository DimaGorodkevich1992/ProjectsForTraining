package by.gorodkevich.online.wallet.security;

import by.gorodkevich.online.wallet.entity.UserEntity;
import by.gorodkevich.online.wallet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userService.findByEmail(email);

        if (user == null) {
            String message = "User \"" + email + "\" not found";
            LOGGER.info(message);
            throw new UsernameNotFoundException(message);
        } else {
            LOGGER.info("User \"{}\" found", email);
        }

        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
}
