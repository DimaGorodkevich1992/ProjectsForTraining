package by.gorodkevich.config;


import by.gorodkevich.models.IndexRequest;
import by.gorodkevich.mongoRepository.EmailRepository;
import by.gorodkevich.service.StoreService;
import by.gorodkevich.service.impl.EmailStoreService;
import by.gorodkevich.service.impl.QueueNotifyingStoreService;
import jms.services.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "jms")
public class AppConfig {
    @Autowired
    private Sender messageSender;
    @Autowired
    private EmailRepository emailRepositoryCustomImpl;

    @Bean
    public StoreService queueNotifyingStoreService() {
        return new QueueNotifyingStoreService(messageSender, new EmailStoreService(emailRepositoryCustomImpl));
    }




}


