package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.CheckEntity;
import by.gorodkevich.app.persistence.entity.ClientEntity;
import by.gorodkevich.app.persistence.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<CheckEntity, Integer> {

    //read
    CheckEntity findById(int id);

    CheckEntity findByRequestEntity_UniqueNumber(int uniqueNumber);

}
