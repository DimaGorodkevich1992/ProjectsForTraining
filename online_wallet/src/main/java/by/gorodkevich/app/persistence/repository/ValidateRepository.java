package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.ValidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidateRepository extends JpaRepository<ValidateEntity,Integer> {
}
