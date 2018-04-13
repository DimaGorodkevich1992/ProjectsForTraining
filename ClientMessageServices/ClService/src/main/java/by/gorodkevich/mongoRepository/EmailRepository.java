package by.gorodkevich.mongoRepository;

import by.gorodkevich.models.MongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmailRepository extends MongoRepository<MongoEntity,String>,EmailRepositoryCustom {

    MongoEntity findById(String id);


}
