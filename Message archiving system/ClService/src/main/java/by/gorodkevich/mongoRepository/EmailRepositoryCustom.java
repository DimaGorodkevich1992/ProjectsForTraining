package by.gorodkevich.mongoRepository;

import by.gorodkevich.models.ClientGetRequest;
import by.gorodkevich.models.ClientUpdateRequest;
import by.gorodkevich.models.Email;

import java.util.Collection;

public interface EmailRepositoryCustom {

    void update(Collection<ClientUpdateRequest> batchMessages);

    Collection<Email> findAll(Collection<ClientGetRequest> batchRequests);

}
