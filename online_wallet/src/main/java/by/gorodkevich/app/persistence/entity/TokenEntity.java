package by.gorodkevich.app.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "token")
public class TokenEntity extends Common {
    @Id
    @Column(name = "token_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "token_token")
    private String token;
    @Column(name = "token_status")
    private Boolean isActive;
    @OneToOne
    @JoinColumn(name = "token_check_id")
    private CheckEntity checkEntity;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CheckEntity getCheckEntity() {
        return checkEntity;
    }

    public void setCheckEntity(CheckEntity checkEntity) {
        this.checkEntity = checkEntity;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "TokenEntity{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", isActive=" + isActive +
                ", checkEntity=" + checkEntity +
                '}';
    }
}
