package by.gorodkevich.online.wallet.entity;

import javax.persistence.*;

@Entity
@Table(name = "validate")
public class ValidateEntity extends CommonEntity {
    @Id
    @Column(name = "validate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "validate_token")
    private String token;
    @Column(name = "validate_key")
    private Long key;
    @Column(name = "validate_status")
    private Boolean isActive;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
