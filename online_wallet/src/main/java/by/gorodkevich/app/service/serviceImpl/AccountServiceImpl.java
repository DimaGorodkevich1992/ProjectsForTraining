package by.gorodkevich.app.service.serviceImpl;

import by.gorodkevich.app.persistence.entity.AccountEntity;
import by.gorodkevich.app.persistence.repository.AccountRepository;
import by.gorodkevich.app.service.AccountService;
import by.gorodkevich.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientService clientService;
    /**
     * метод для генерации уникального номера аккаунта
     * @return возвращает номер long
     */
    private long accountNumberCreator() {
        long min = 1000000000000000L;
        long max = 9999999999999999L;

        return ThreadLocalRandom.current().nextLong(min, max);

    }

    @Override
    public void addAccount() {
        long randomNumber = accountNumberCreator();
        if (accountRepository.findByNumber(randomNumber) == null) {
            AccountEntity newAccount = new AccountEntity();
            newAccount.setNumber(randomNumber);
            newAccount.setMoney(0.00);
            newAccount.setStatusActive(true);
            accountRepository.save(newAccount);
        } else addAccount();
    }

    @Override
    public void updateIsActiveForAdmin(long numberAccount, boolean status) {
        AccountEntity accountForChange = accountRepository.findByNumber(numberAccount);
        accountForChange.setStatusActive(status);
        accountRepository.save(accountForChange);

    }

    @Override
    public void updateIsActiveForClient(long numberAccount) {
        AccountEntity accountForChange = accountRepository.findByNumber(numberAccount);
        accountForChange.setStatusActive(false);
        accountRepository.save(accountForChange);
    }

    @Override
    public AccountEntity findByNumber(long numberAccount) {
        return accountRepository.findByNumber(numberAccount);

    }

    @Override
    public List<AccountEntity> findInfoList(String clientName) {
        return accountRepository.findByClientEntity(clientService.getClient());
    }
}
