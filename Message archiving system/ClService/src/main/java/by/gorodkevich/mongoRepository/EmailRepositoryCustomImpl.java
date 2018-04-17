package by.gorodkevich.mongoRepository;

import by.gorodkevich.models.ClientGetRequest;
import by.gorodkevich.models.ClientUpdateRequest;
import by.gorodkevich.models.MongoEntity;
import by.gorodkevich.models.Email;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class EmailRepositoryCustomImpl implements EmailRepositoryCustom {
    @Autowired
    private MongoOperations mongoOperations;


    @Override
    public void update(Collection<ClientUpdateRequest> batchMessages) {
        for (ClientUpdateRequest request : batchMessages) {
            Query query = new Query(where("id").is(request.getId()));
            Update update = new Update();
            for (Map.Entry<String, Object> entry : request.getFieldsToUpdates().entrySet()) {
                  update.set(entry.getKey(), entry.getValue());
            }
            mongoOperations.upsert(query, update, MongoEntity.class);
        }
    }

    @Override
    public Collection<Email> findAll(Collection<ClientGetRequest> batchRequests) {
        Collection<MongoEntity> listEntity = new ArrayList<>();
        Collection<Email> listEmail = new ArrayList<>();
        for (ClientGetRequest request : batchRequests) {
            Query query = new Query(where("id").is(request.getId()));
            if (request.getFieldList() == null) {
                listEntity.add(mongoOperations.findOne(query, MongoEntity.class));

            } else {
                for (String field : request.getFieldList()) {
                    query.fields().include(field);
                }
                listEntity.add(mongoOperations.findOne(query, MongoEntity.class));
            }
        }

        for (MongoEntity entity : listEntity) {
            Email email = new Email();
            BeanUtils.copyProperties(entity, email);
            listEmail.add(email);
        }

        return listEmail;
    }

}

