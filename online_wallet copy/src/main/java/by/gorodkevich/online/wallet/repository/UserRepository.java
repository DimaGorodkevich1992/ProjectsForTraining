package by.gorodkevich.online.wallet.repository;

import by.gorodkevich.online.wallet.entity.UserEntity;

public interface UserRepository extends CommonRepository<UserEntity> {
    UserEntity findByEmail(String email);
}
