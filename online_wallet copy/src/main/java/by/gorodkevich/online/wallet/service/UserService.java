package by.gorodkevich.online.wallet.service;

import by.gorodkevich.online.wallet.entity.UserEntity;
import by.gorodkevich.online.wallet.vo.UserVO;

public interface UserService extends CommonService<UserEntity> {

    UserEntity findByEmail(String email);

    UserEntity createUser(UserEntity userEntity);

    UserEntity updatePassword(UserVO userVO);
}
