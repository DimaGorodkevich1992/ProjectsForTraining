package by.gorodkevich.TetsRepository;

import by.gorodkevich.Config.FongoConfig;
import by.gorodkevich.models.ClientUpdateRequest;
import by.gorodkevich.models.MongoEntity;
import by.gorodkevich.mongoRepository.EmailRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@ActiveProfiles({"fongoConfig"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FongoConfig.class})
@SpringBootTest
public class TestMongoRepository {

    @Autowired
    private EmailRepository repository;

    @Test
    public void testStore() {
        Collection<String> collection = new ArrayList<>();
        Collection<MongoEntity> content1 = new ArrayList<>();
        MongoEntity request = new MongoEntity();
        request.setId("127");
        request.setBody("proverka");
        request.setFrom("dima");
        request.setSendDateTime(LocalDateTime.now());
        request.setSize(123L);
        request.setSubject("Hello my services");
        request.setTo(collection);
        content1.add(request);

        repository.save(content1);

        assertEquals("dima", repository.findById("127").getFrom());


    }

    @Test
    public void testUpdate() {
        ClientUpdateRequest requestToUpdate = new ClientUpdateRequest();
        Collection<ClientUpdateRequest> content = new ArrayList<>();
        Map<String, Object> fieldList = new HashMap<>();
        fieldList.put("size", "40000");
        requestToUpdate.setId("127");
        requestToUpdate.setFieldsToUpdates(fieldList);
        content.add(requestToUpdate);

        repository.update(content);
        assertEquals(new Long(40000l), repository.findById("127").getSize());
    }


}
