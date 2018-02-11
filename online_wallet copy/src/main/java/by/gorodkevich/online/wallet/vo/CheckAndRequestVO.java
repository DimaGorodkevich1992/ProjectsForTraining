package by.gorodkevich.online.wallet.vo;

public class CheckAndRequestVO {
    private Long toAccountNumber;
    private Long fromAccountNumber;
    private Integer moneyAmount;
    private Long typeOperation;

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public Long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public Integer getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Integer moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Long getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(Long typeOperation) {
        this.typeOperation = typeOperation;
    }
}
