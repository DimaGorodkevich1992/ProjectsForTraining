package by.gorodkevich.online.wallet.repository;


import by.gorodkevich.online.wallet.entity.TypeOperationEntity;

public interface TypeOperationRepository extends CommonRepository<TypeOperationEntity> {

    //read
    TypeOperationEntity findById(long id);
}
