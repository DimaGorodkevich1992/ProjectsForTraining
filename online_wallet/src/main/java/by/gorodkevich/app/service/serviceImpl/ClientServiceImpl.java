package by.gorodkevich.app.service.serviceImpl;

import by.gorodkevich.app.persistence.entity.ClientEntity;
import by.gorodkevich.app.persistence.repository.ClientRepository;
import by.gorodkevich.app.service.ClientService;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    /**
     * метод для проверки пароля
     *
     * @param openPassword открытый пароль
     * @param hashPassword хешированный пароль
     * @return возвращает результат сравнения
     */
    private static Boolean validatePassword(String openPassword, String hashPassword) {
        return BCrypt.checkpw(openPassword, hashPassword);
    }

    private static Boolean validateLenghtPassword(String password) {
        if (password.length() < 8 | password.length() > 20) {
            return false;
        } else return true;
    }

    /**
     * метод для хеширования пароля с солью
     *
     * @param password открытый пароль
     * @return хешированный пароль
     */
    private static String hashPassword(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

    @Override
    public ClientEntity getClient() {
        return new ClientEntity();
    }

    @Override
    public void addClient(ClientEntity clientEntity) {
        if (validateLenghtPassword(clientEntity.getPassword())) {
            clientEntity.setPassword(hashPassword(clientEntity.getPassword()));
            clientEntity.setAdmin(false);
            clientRepository.save(clientEntity);
        } else System.out.println("неверный пароль");

    }

    @Override
    public boolean updatePassword(String oldPassword, String newPassword) {
        return true;

    }
}
