package by.gorodkevich.app.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "validate")
public class ValidateEntity extends Common {
    @Id
    @Column(name = "validate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "validate_token")
    private String token;
    @Column(name = "validate_key")
    private String key;
    @OneToOne
    @JoinColumn(name = "validate_check_id")
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CheckEntity getCheckEntity() {
        return checkEntity;
    }

    public void setCheckEntity(CheckEntity checkEntity) {
        this.checkEntity = checkEntity;
    }

    @Override
    public String toString() {
        return "ValidateEntity{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", key='" + key + '\'' +
                ", checkEntity=" + checkEntity +
                '}';
    }
}
