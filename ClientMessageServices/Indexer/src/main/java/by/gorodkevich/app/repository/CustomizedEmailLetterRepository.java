package by.gorodkevich.app.repository;

import by.gorodkevich.app.models.SolrEntity;

import java.util.Collection;

public interface CustomizedEmailLetterRepository {


    void submit(Collection<SolrEntity> collection);



}
