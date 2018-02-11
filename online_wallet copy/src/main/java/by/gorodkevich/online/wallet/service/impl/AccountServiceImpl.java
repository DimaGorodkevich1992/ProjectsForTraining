package by.gorodkevich.online.wallet.service.impl;


import by.gorodkevich.online.wallet.entity.AccountEntity;
import by.gorodkevich.online.wallet.repository.AccountRepository;
import by.gorodkevich.online.wallet.service.AccountService;
import by.gorodkevich.online.wallet.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountServiceImpl extends CommonServiceImpl<AccountEntity> implements AccountService {

    private AccountRepository repository;

    @Autowired
    private CurrentUserService currentUserService;


    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * метод для генерации уникального номера аккаунта
     *
     * @return возвращает номер long
     */
    private long accountNumberCreator() {
        long min = 1000000000000000L;
        long max = 9999999999999999L;

        return ThreadLocalRandom.current().nextLong(min, max);

    }

    @Override
    public AccountEntity createAccount() {
        long randomNumber = accountNumberCreator();
        AccountEntity newAccount = new AccountEntity();
        if (repository.findByNumber(randomNumber) == null) {
            newAccount.setNumber(randomNumber);
            newAccount.setMoney(0);
            newAccount.setStatusActive(true);
            newAccount.setUserEntity(currentUserService.get());
        } else createAccount();
        return repository.save(newAccount);
    }

    @Override
    public AccountEntity updateIsActiveForAdmin(long numberAccount, boolean status) {
        AccountEntity accountForChange = repository.findByNumber(numberAccount);
        accountForChange.setStatusActive(status);
        return repository.save(accountForChange);
    }

    @Override
    public AccountEntity updateIsActiveForClient(long numberAccount) {
        AccountEntity accountForChange = repository.findByNumber(numberAccount);
        accountForChange.setStatusActive(false);
       return repository.save(accountForChange);
    }

    @Override
    public AccountEntity findByNumber(long numberAccount) {
        return repository.findByNumber(numberAccount);

    }

    @Override
    public List<AccountEntity> getInfoList() {
        return repository.findByUserEntity(currentUserService.get());
    }
}
