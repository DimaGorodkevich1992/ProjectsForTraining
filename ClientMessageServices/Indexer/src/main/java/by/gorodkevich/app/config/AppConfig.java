package by.gorodkevich.app.config;

import by.gorodkevich.app.repository.EmailRepository;
import by.gorodkevich.app.service.IndexingService;
import by.gorodkevich.app.service.impl.IndexingBatchCallback;
import by.gorodkevich.app.service.impl.EmailIndexingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig{
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
    @Bean
    public IndexingService storeService(){
        return new EmailIndexingService(emailRepository);
    }
    @Bean
    public IndexingBatchCallback indexerEndpoint(){
        return new IndexingBatchCallback(storeService(),restTemplate());
    }



  /* @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        URI uri = new URI("http://localhost", "8080/get", "");

        return args -> {

            ResponseEntity<Collection> text = restTemplate.postForEntity(uri, batchRequests, Collection.class);
        };
    }*/


}
