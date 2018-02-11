package by.gorodkevich.online.wallet.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private long id;
    @Column(name = "account_status")
    private Boolean statusActive;
    @ManyToOne
    @JoinColumn(name = "account_users_id")
    private UserEntity userEntity;
    @Column(name = "account_money")
    private Integer money;
    @Column(name = "account_number")
    private Long number;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Boolean getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(Boolean statusActive) {
        this.statusActive = statusActive;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
