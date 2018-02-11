package by.gorodkevich.online.wallet.entity;


import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "history")
public class HistoryEntity extends CommonEntity {
    @Id
    @Column(name = "history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "history_type_operation_id")
    private TypeOperationEntity typeOperationEntity;
    @ManyToOne
    @JoinColumn(name = "history_account_id")
    private AccountEntity accountEntity;
    @Column(name = "history_money")
    private Integer money;
    @Column(name = "history_time")
    private OffsetDateTime dateTime;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }


}
