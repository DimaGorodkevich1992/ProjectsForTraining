package by.gorodkevich.online.wallet.repository;


import by.gorodkevich.online.wallet.entity.RequestEntity;
import by.gorodkevich.online.wallet.entity.ValidateEntity;

public interface RequestRepository extends CommonRepository<RequestEntity> {

    //read

    RequestEntity findById(long id);

    RequestEntity findByValidateEntity(ValidateEntity validateEntity);
}
