package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {

    TokenEntity findByToken(String token);
}
