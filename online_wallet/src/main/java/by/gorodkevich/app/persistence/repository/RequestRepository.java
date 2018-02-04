package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity,Integer> {

    //read

    RequestEntity findById(int id);

    RequestEntity findByUniqueNumber(int uniqueNumber);
}
