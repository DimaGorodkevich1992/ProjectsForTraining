package by.gorodkevich.app.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;
    @Column(name = "account_status")
    private Boolean statusActive;
    @ManyToOne
    @JoinColumn(name = "account_client_id")
    private ClientEntity clientEntity;
    @Column(name = "account_money")
    private Double money;
    @Column(name = "account_number")
    private Long number;

    public AccountEntity() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Boolean getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(Boolean statusActive) {
        this.statusActive = statusActive;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", statusActive=" + statusActive +
                ", clientEntity=" + clientEntity +
                ", money=" + money +
                ", number=" + number +
                '}';
    }
}
