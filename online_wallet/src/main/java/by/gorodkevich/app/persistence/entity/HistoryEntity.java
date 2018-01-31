package by.gorodkevich.app.persistence.entity;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class HistoryEntity extends Common {
    @Id
    @Column(name = "history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "history_type_operation_id")
    private TypeOperationEntity typeOperationEntity;
    @ManyToOne
    @JoinColumn(name = "history_account_id")
    private AccountEntity accountEntity;
    @Column(name = "history_money")
    private Double money;
    @Column(name = "history_time")
    private DateTime dateTime;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public TypeOperationEntity getTypeOperationEntity() {
        return typeOperationEntity;
    }

    public void setTypeOperationEntity(TypeOperationEntity typeOperationEntity) {
        this.typeOperationEntity = typeOperationEntity;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "HistoryEntity{" +
                "id=" + id +
                ", typeOperationEntity=" + typeOperationEntity +
                ", accountEntity=" + accountEntity +
                ", money=" + money +
                ", dateTime=" + dateTime +
                '}';
    }
}
