package by.gorodkevich.service.impl;

import by.gorodkevich.models.*;
import by.gorodkevich.service.StoreService;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class QueueNotifyingStoreService implements StoreService {
    private QueueEndpoint<IndexRequest> endpoint;
    private StoreService delegateStoreService;

    public QueueNotifyingStoreService(QueueEndpoint<IndexRequest> endpoint, StoreService delegateStoreService) {
        this.endpoint = endpoint;
        this.delegateStoreService = delegateStoreService;
    }

    @Override
    public void store(Collection<ClientStoreStoreRequestWithId> batchMessages) {
        delegateStoreService.store(batchMessages);

        List<IndexRequest> listRequest = new ArrayList<>();
        for (ClientStoreStoreRequestWithId clientRequest : batchMessages) {
            IndexRequest indexRequest = new IndexRequest();

            indexRequest.setId(clientRequest.getId());
            indexRequest.setDateTime(LocalDateTime.now());

            listRequest.add(indexRequest);
        }

        endpoint.sendBatch(listRequest);
    }

    @Override
    public void update(Collection<ClientUpdateRequest> batchMessages) {
        delegateStoreService.update(batchMessages);


        List<IndexRequest> listRequest = new ArrayList<>();
        for (ClientUpdateRequest request : batchMessages) {

            //Collection for indexRequest
            Collection<String> fieldsList = new ArrayList<>();

            for (Map.Entry<String, Object> entity : request.getFieldsToUpdates().entrySet()) {
                fieldsList.add(entity.getKey());
            }
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.setId(request.getId());
            indexRequest.setFieldList(fieldsList);
            indexRequest.setDateTime(LocalDateTime.now());
            listRequest.add(indexRequest);
        }
        endpoint.sendBatch(listRequest);

    }

    @Override
    public Collection<Email> get(Collection<ClientGetRequest> batchRequests) {
        return delegateStoreService.get(batchRequests);
    }


}
