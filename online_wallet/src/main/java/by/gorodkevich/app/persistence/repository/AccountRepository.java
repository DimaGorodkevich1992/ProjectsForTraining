package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.AccountEntity;
import by.gorodkevich.app.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    //Read

    AccountEntity findByNumber(long number);

    List<AccountEntity> findByClientEntity(ClientEntity clientEntity);
}
