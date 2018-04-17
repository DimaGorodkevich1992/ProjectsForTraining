package by.gorodkevich.service.impl;

import by.gorodkevich.models.*;
import by.gorodkevich.service.StoreService;
import jms.services.Sender;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class QueueNotifyingStoreService implements StoreService {
    private Sender messageSender;
    private StoreService delegateStoreService;

    public QueueNotifyingStoreService(Sender messageSender, StoreService delegateStoreService) {
        this.messageSender = messageSender;
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

        messageSender.sendCollection(listRequest);
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
        messageSender.sendCollection(listRequest);

    }

    @Override
    public Collection<Email> get(Collection<ClientGetRequest> batchRequests) {
        return delegateStoreService.get(batchRequests);
    }


}
