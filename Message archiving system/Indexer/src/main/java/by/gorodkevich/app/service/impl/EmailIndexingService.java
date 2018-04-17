package by.gorodkevich.app.service.impl;

import by.gorodkevich.app.models.SolrEntity;
import by.gorodkevich.app.repository.EmailRepository;
import by.gorodkevich.app.service.IndexingService;

import java.util.Collection;

public class EmailIndexingService implements IndexingService{

    private EmailRepository emailRepository;

    public EmailIndexingService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void submit(Collection<SolrEntity> entityCollection) {
        emailRepository.submit(entityCollection);
    }


}
