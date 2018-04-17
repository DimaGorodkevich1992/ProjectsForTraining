package by.gorodkevich.service.impl;

import by.gorodkevich.models.*;
import by.gorodkevich.mongoRepository.EmailRepository;
import by.gorodkevich.service.StoreService;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;


public class EmailStoreService implements StoreService {
    private EmailRepository repository;

    public EmailStoreService(EmailRepository repository) {
        this.repository = repository;
    }

    @Override
    public void store(Collection<ClientStoreStoreRequestWithId> batchMessages) {
        Collection<MongoEntity> listMongoMessage = new ArrayList<>();

        for (ClientStoreStoreRequestWithId request : batchMessages) {
            MongoEntity mongoEntity = new MongoEntity();

            BeanUtils.copyProperties(request, mongoEntity);
            mongoEntity.setStatus(Status.NOT_REVIEWED);
            listMongoMessage.add(mongoEntity);
        }

        repository.saveAll(listMongoMessage);
    }

    @Override
    public void update(Collection<ClientUpdateRequest> batchMessages) {
        repository.update(batchMessages);
    }

    @Override
    public Collection<Email> get(Collection<ClientGetRequest> batchRequests) {

        return repository.findAll(batchRequests);
    }


}
