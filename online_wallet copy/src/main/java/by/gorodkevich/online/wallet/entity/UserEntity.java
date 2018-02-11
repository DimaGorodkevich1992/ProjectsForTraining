package by.gorodkevich.online.wallet.entity;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends CommonEntity {
    @Id
    @Column(name = "users_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "users_email")
    private String email;
    @Column(name = "users_password")
    private String password;
    @Column(name = "users_name")
    private String name;
    @Column(name = "users_is_admin")
    private Boolean isAdmin;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
