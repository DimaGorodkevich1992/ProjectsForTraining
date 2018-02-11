package by.gorodkevich.online.wallet.controller;


import by.gorodkevich.online.wallet.service.IOMoneyInSystem;
import by.gorodkevich.online.wallet.service.InternalMoneyTransferService;
import by.gorodkevich.online.wallet.service.PaymentProcessorService;
import by.gorodkevich.online.wallet.vo.CheckAndRequestVO;
import by.gorodkevich.online.wallet.vo.ValidateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CommonController.PATH+"/payTransfer")
public class PayTransferController  {
    @Autowired
    private IOMoneyInSystem ioMoneyInSystem;
    @Autowired
    private InternalMoneyTransferService internalMoneyTransferService;
    @Autowired
    private PaymentProcessorService paymentProcessorService;

    @PostMapping("/pay")
    public String pay(@RequestBody CheckAndRequestVO checkAndRequestVO) {
        return paymentProcessorService.requestToPay(checkAndRequestVO);
    }

    @PostMapping("/acceptPay")
    public void acceptPay(@RequestBody ValidateVO validateVO) {
        paymentProcessorService.acceptPay(validateVO);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody CheckAndRequestVO check) {
        internalMoneyTransferService.move(check.getToAccountNumber(),check.getFromAccountNumber()
        ,check.getMoneyAmount());
    }

    @PostMapping("/input")
    public void inputMoney(@RequestParam(value = "number") Long accNumber,@RequestParam(value = "money") Integer amount) {
        ioMoneyInSystem.inputMoney(accNumber, amount);
    }
}
