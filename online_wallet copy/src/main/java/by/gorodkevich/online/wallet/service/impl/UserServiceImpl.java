package by.gorodkevich.online.wallet.service.impl;

import by.gorodkevich.online.wallet.entity.UserEntity;
import by.gorodkevich.online.wallet.repository.CommonRepository;
import by.gorodkevich.online.wallet.repository.UserRepository;
import by.gorodkevich.online.wallet.service.CurrentUserService;
import by.gorodkevich.online.wallet.service.UserService;
import by.gorodkevich.online.wallet.vo.UserVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CommonServiceImpl<UserEntity> implements UserService {
    @Autowired
    private CurrentUserService currentUserService;

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }


    private static Boolean validatePassword(String openPassword, String hashPassword) {
        return BCrypt.checkpw(openPassword, hashPassword);
    }

    private static String hashPassword(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

    private static Boolean validateLengthPassword(String password) {
        if (password.length() < 8 | password.length() > 20) {
            return false;
        } else return true;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        if (validateLengthPassword(userEntity.getPassword())) {
            userEntity.setPassword(hashPassword(userEntity.getPassword()));
            userEntity.setAdmin(false);
            return repository.save(userEntity);
        } else throw new IllegalArgumentException();
    }

    @Override
    public UserEntity updatePassword(UserVO userVO) {
        if(validatePassword(userVO.getOldPassword(), currentUserService.get().getPassword())) {
            UserEntity currentUser = currentUserService.get();
            currentUser.setPassword(hashPassword(userVO.getNewPassword()));
            return repository.save(currentUser);
        }else throw new IllegalArgumentException();
    }

    @Override
    public UserEntity findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
