package by.gorodkevich.online.wallet.entity;


import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "cheque")
public class ChequeEntity extends CommonEntity {
    @Id
    @Column(name = "cheque_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cheque_money")
    private Integer money;
    @Column(name = "cheque_time")
    private OffsetDateTime dateTime;
    @OneToOne
    @JoinColumn(name = "cheque_type_operation_id")
    private TypeOperationEntity typeOperationEntity;
    @OneToOne
    @JoinColumn(name = "cheque_validate_id")
    private ValidateEntity validateEntity;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
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

    public TypeOperationEntity getTypeOperationEntity() {
        return typeOperationEntity;
    }

    public void setTypeOperationEntity(TypeOperationEntity typeOperationEntity) {
        this.typeOperationEntity = typeOperationEntity;
    }

    public ValidateEntity getValidateEntity() {
        return validateEntity;
    }

    public void setValidateEntity(ValidateEntity validateEntity) {
        this.validateEntity = validateEntity;
    }
}
