package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.TypeOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOperationRepository extends JpaRepository<TypeOperationEntity, Integer> {

    //read
    TypeOperationEntity findById(int id);
}
