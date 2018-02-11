package by.gorodkevich.online.wallet.entity;

import javax.persistence.*;

@Entity
@Table(name = "type_operation")
public class TypeOperationEntity extends CommonEntity {
    @Id
    @Column(name = "type_operation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type_operation_value")
    private String operationValue;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(String operationValue) {
        this.operationValue = operationValue;
    }

}
