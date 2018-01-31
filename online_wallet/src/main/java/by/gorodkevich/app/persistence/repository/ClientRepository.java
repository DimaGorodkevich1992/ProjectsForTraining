package by.gorodkevich.app.persistence.repository;

import by.gorodkevich.app.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {

    ClientEntity findByName(String name);



}
