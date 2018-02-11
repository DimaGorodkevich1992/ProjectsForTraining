package by.gorodkevich.online.wallet.entity;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class RequestEntity extends CommonEntity {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "request_from_acc_number")
    private Long fromAccNumber;
    @Column(name = "request_to_acc_number")
    private Long toAccNumber;
    @OneToOne
    @JoinColumn(name = "request_validate_id")
    private ValidateEntity validateEntity;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Long getFromAccNumber() {
        return fromAccNumber;
    }

    public void setFromAccNumber(Long fromAccNumber) {
        this.fromAccNumber = fromAccNumber;
    }

    public Long getToAccNumber() {
        return toAccNumber;
    }

    public void setToAccNumber(Long toAccNumber) {
        this.toAccNumber = toAccNumber;
    }

    public ValidateEntity getValidateEntity() {
        return validateEntity;
    }

    public void setValidateEntity(ValidateEntity validateEntity) {
        this.validateEntity = validateEntity;
    }
}
