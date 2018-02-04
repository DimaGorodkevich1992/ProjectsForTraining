package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity, Integer> {

    //read

    List<HistoryEntity> findByAccountEntity_Number(long number);
}
