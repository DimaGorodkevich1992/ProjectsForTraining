package by.gorodkevich.app.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class ClientEntity extends Common {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "client_name")
    private String name;
    @Column(name = "client_password")
    private String password;
    @Column(name = "client_email")
    private String email;
    @Column(name = "client_is_admin")
    private Boolean isAdmin;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
