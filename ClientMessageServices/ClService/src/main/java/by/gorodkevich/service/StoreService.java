package by.gorodkevich.service;

import by.gorodkevich.models.ClientGetRequest;
import by.gorodkevich.models.ClientUpdateRequest;
import by.gorodkevich.models.ClientStoreStoreRequestWithId;
import by.gorodkevich.models.Email;

import java.util.Collection;

public interface StoreService {

    void store(Collection<ClientStoreStoreRequestWithId> batchMessages);

    void update(Collection<ClientUpdateRequest> batchMessages);

    Collection<Email> get(Collection<ClientGetRequest> batchRequests);

}
