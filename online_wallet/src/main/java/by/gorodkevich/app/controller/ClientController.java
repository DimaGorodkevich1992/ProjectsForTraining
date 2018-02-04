package by.gorodkevich.app.controller;

import by.gorodkevich.app.persistence.entity.ClientEntity;
import by.gorodkevich.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
     ClientService clientService;

    @PostMapping(value = "/create")
    public void createClient(@RequestBody ClientEntity newClient) {
        clientService.addClient(newClient);
    }

}
