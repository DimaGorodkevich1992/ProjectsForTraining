package by.gorodkevich.online.wallet.repository;

import by.gorodkevich.online.wallet.entity.AccountEntity;
import by.gorodkevich.online.wallet.entity.UserEntity;

import java.util.List;

public interface AccountRepository extends CommonRepository<AccountEntity> {

    AccountEntity findByNumber(long number);

    List<AccountEntity> findByUserEntity(UserEntity userEntity);
}
