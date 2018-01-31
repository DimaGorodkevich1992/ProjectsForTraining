package by.gorodkevich.app.persistence.entity;

import org.joda.time.DateTime;

import javax.persistence.*;

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
    private DateTime dateTime;
    @OneToOne
    @JoinColumn(name = "check_type_operation_id")
    private TypeOperationEntity typeOperationEntity;

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

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TypeOperationEntity getTypeOperationEntity() {
        return typeOperationEntity;
    }

    public void setTypeOperationEntity(TypeOperationEntity typeOperationEntity) {
        this.typeOperationEntity = typeOperationEntity;
    }

    @Override
    public String toString() {
        return "CheckEntity{" +
                "id=" + id +
                ", money=" + money +
                ", dateTime=" + dateTime +
                ", typeOperationEntity=" + typeOperationEntity +
                '}';
    }
}
