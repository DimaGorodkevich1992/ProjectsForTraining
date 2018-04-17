package by.gorodkevich.controller;

import by.gorodkevich.models.ClientGetRequest;
import by.gorodkevich.models.ClientStoreStoreRequestWithId;
import by.gorodkevich.models.ClientUpdateRequest;
import by.gorodkevich.models.Email;
import by.gorodkevich.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ClientController {

    private StoreService storeService;

    public ClientController(StoreService notifyQueueDecorator) {
        this.storeService = notifyQueueDecorator;
    }

    @PostMapping(value = "/store")
    public void store(@RequestBody Collection<ClientStoreStoreRequestWithId> requests){
        storeService.store(requests);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody Collection<ClientUpdateRequest> requests){
        storeService.update(requests);
    }

    @PostMapping(value = "/get")
    public Collection<Email> get(@RequestBody Collection<ClientGetRequest> requests){
        return storeService.get(requests);
    }

}
