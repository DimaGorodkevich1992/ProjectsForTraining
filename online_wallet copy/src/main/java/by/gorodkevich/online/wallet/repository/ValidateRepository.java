package by.gorodkevich.online.wallet.repository;


import by.gorodkevich.online.wallet.entity.ValidateEntity;

public interface ValidateRepository extends CommonRepository<ValidateEntity> {

    ValidateEntity findByTokenAndKey(String token, Long key);

    ValidateEntity findByToken(String token);
}
