package by.gorodkevich.online.wallet.controller;

import by.gorodkevich.online.wallet.entity.AccountEntity;
import by.gorodkevich.online.wallet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CommonController.PATH + "/account")
public class AccountController extends CommonController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public AccountEntity createAccount() {
        return accountService.createAccount();
    }

    @PostMapping("/changeStatus")
    public AccountEntity changeAccountStatus(@RequestBody AccountEntity currentAccount) {
        return accountService.updateIsActiveForClient(currentAccount.getNumber());
    }

    @GetMapping()
    public List<AccountEntity> getInfoList() {
        return accountService.getInfoList();
    }

}
