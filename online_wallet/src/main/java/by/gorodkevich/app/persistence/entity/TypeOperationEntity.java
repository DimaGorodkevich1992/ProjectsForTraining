package by.gorodkevich.app.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "type_operation")
public class TypeOperationEntity extends Common {
    @Id
    @Column(name = "type_operation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type_operation_value")
    private String operationValue;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(String operationValue) {
        this.operationValue = operationValue;
    }

    @Override
    public String toString() {
        return "TypeOperationEntity{" +
                "id=" + id +
                ", operationValue='" + operationValue + '\'' +
                '}';
    }
}
