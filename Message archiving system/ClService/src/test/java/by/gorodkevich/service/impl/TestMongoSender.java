package by.gorodkevich.service.impl;

import by.gorodkevich.models.MongoEntity;
import by.gorodkevich.mongoRepository.EmailRepository;
import by.gorodkevich.service.impl.EmailStoreService;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class TestMongoSender {
    @Test
    public void getMongoSend() {
        EmailRepository repository = mock(EmailRepository.class);

        Collection<MongoEntity> collectionMongo = new ArrayList<>();

        EmailStoreService service = new EmailStoreService(repository);


    }


}
