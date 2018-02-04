package by.gorodkevich.app.persistence.entity;



import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "check")
public class CheckEntity extends Common {
    @Id
    @Column(name= "check_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "check_money")
    private Double money;
    @Column(name = "check_time")
    private OffsetDateTime dateTime;
    @OneToOne
    @JoinColumn(name = "check_type_operation_id")
    private TypeOperationEntity typeOperationEntity;
    @OneToOne
    @JoinColumn(name = "check_request_id")
    private RequestEntity requestEntity;
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
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

    public RequestEntity getRequestEntity() {
        return requestEntity;
    }

    public void setRequestEntity(RequestEntity requestEntity) {
        this.requestEntity = requestEntity;
    }

    @Override
    public String toString() {
        return "CheckEntity{" +
                "id=" + id +
                ", money=" + money +
                ", dateTime=" + dateTime +
                ", typeOperationEntity=" + typeOperationEntity +
                ", requestEntity=" + requestEntity +
                '}';
    }
}
