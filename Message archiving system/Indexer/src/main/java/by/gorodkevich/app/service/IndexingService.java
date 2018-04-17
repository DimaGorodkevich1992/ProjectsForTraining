package by.gorodkevich.app.service;

import by.gorodkevich.app.models.SolrEntity;

import java.util.Collection;

public interface IndexingService {


    void submit(Collection<SolrEntity> entityCollection);
}
