package by.gorodkevich.app.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class RequestEntity extends Common {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "request_from_acc_number")
    private Long fromAccNumber;
    @Column(name = "request_to_acc_number")
    private Long toAccNumber;
    @OneToOne
    @JoinColumn(name = "request_check_id")
    private CheckEntity checkEntity;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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

    public CheckEntity getCheckEntity() {
        return checkEntity;
    }

    public void setCheckEntity(CheckEntity checkEntity) {
        this.checkEntity = checkEntity;
    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "id=" + id +
                ", fromAccNumber=" + fromAccNumber +
                ", toAccNumber=" + toAccNumber +
                ", checkEntity=" + checkEntity +
                '}';
    }
}
