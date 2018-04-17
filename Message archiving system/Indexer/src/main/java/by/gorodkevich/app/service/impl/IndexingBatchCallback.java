package by.gorodkevich.app.service.impl;

import by.gorodkevich.app.models.SolrEntity;
import by.gorodkevich.app.service.IndexingService;
import by.gorodkevich.models.ClientGetRequest;
import by.gorodkevich.models.Email;
import by.gorodkevich.models.IndexRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IndexingBatchCallback implements BatchMessageCallback<IndexRequest> {
    private IndexingService indexingService;
    private RestTemplate restTemplate;

    public IndexingBatchCallback(IndexingService indexingService, RestTemplate restTemplate) {
        this.indexingService = indexingService;
        this.restTemplate = restTemplate;
    }


    @Override
    public void onMessages(List<IndexRequest> objs) {
        Collection<ClientGetRequest> clientRequests = new ArrayList<>();
        Collection<SolrEntity> entityCollection = new ArrayList<>();

        for (IndexRequest indexRequest : objs) {
            ClientGetRequest clientRequest = new ClientGetRequest();
            clientRequest.setId(indexRequest.getId());
            clientRequest.setFieldList(indexRequest.getFieldList());
            clientRequests.add(clientRequest);
        }

        ResponseEntity<Email[]> responseEntity = restTemplate.postForEntity("http://localhost:8080/get", clientRequests, Email[].class);
        for (Email email : responseEntity.getBody()) {
            SolrEntity solrEntity = new SolrEntity();
            BeanUtils.copyProperties(email, solrEntity);
            entityCollection.add(solrEntity);
        }
        indexingService.submit(entityCollection);

    }
}