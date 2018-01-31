package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<CheckEntity,Integer> {
}
