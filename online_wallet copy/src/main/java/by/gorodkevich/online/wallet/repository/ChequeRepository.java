package by.gorodkevich.online.wallet.repository;


import by.gorodkevich.online.wallet.entity.ChequeEntity;
import by.gorodkevich.online.wallet.entity.ValidateEntity;

public interface ChequeRepository extends CommonRepository<ChequeEntity> {

    //read
    ChequeEntity findByValidateEntity(ValidateEntity validateEntity);



}
