package by.gorodkevich.config;


import by.gorodkevich.models.IndexRequest;
import by.gorodkevich.mongoRepository.EmailRepository;
import by.gorodkevich.service.StoreService;
import by.gorodkevich.service.impl.EmailStoreService;
import by.gorodkevich.service.impl.QueueNotifyingStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {
    @Autowired
    private QueueEndpoint<IndexRequest> endpoint;
    @Autowired
    private EmailRepository emailRepository;

    @Bean
    public StoreService queueNotifyingStoreService() {
        return new QueueNotifyingStoreService(endpoint, new EmailStoreService(emailRepository));
    }




}


