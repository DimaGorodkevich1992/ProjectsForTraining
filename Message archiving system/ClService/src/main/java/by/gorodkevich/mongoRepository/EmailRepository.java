package by.gorodkevich.mongoRepository;

import by.gorodkevich.models.MongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface EmailRepository extends MongoRepository<MongoEntity,String>,EmailRepositoryCustom {

    Optional<MongoEntity> findById(String id);


}
