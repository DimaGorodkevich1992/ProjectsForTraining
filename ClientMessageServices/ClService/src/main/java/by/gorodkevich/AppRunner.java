package by.gorodkevich;


import by.gorodkevich.models.ClientUpdateRequest;
import by.gorodkevich.service.StoreService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class AppRunner {

    public static void main(String[] args) {
         SpringApplication.run(AppRunner.class, args);
       // ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
       /* Collection<String> fieldList = new ArrayList<>();
        fieldList.add("Dzmitry Haradkevich");
        fieldList.add("Raman Volkau");*/


        /*ClientRequest clientRequest  = new ClientRequest();
        Collection<ClientRequest> batchRequests = new ArrayList<>();
        fieldList.add("body");
        fieldList.add("subject");
        clientRequest.setId("127");
        clientRequest.setFieldList(fieldList);
        batchRequests.add(clientRequest);
        context.getBean(EmailRepository.class).findAll(batchRequests);
*/
        //update email
        /*ClientUpdateRequest requestToUpdate = new ClientUpdateRequest();
        Collection<ClientUpdateRequest> content = new ArrayList<>();
        Map<String,Object> fieldList = new HashMap<>();
        fieldList.put("size","400");
        fieldList.put("status","VIEWED");
        fieldList.put("sendDateTime",LocalDateTime.now());
        requestToUpdate.setId("150");
        requestToUpdate.setFieldsToUpdates(fieldList);
        content.add(requestToUpdate);
*/
        //add email
      /*  ClientStoreStoreRequestWithId request = new ClientStoreStoreRequestWithId();
        ClientStoreStoreRequestWithId request1 = new ClientStoreStoreRequestWithId();
        ClientStoreStoreRequestWithId request2 = new ClientStoreStoreRequestWithId();
        ClientStoreStoreRequestWithId request3 = new ClientStoreStoreRequestWithId();

        Collection<ClientStoreStoreRequestWithId> content1 = new ArrayList<>();
        request1.setId("150");
        request1.setBody("fix date");
        request1.setFrom("Raman Volkau");
        request1.setSubject("Hello Dima and Brest hours asses D4. Need change date to localDateTime!!! Schnelle kleine schweine");
        request1.setTo(fieldList);
        content1.add(request1);*/




    }
}
