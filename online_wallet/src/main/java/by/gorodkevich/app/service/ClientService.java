package by.gorodkevich.app.service;

import by.gorodkevich.app.persistence.entity.ClientEntity;

public interface ClientService {

    ClientEntity getClient();

    void addClient(ClientEntity clientEntity);

    boolean updatePassword(String oldPassword, String newPassword);

}
