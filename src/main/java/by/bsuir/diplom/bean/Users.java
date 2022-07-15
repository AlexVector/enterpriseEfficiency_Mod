package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "users", schema = "company_db")
public class Users extends Entity{

    @Column(name = "email", nullable = false, length = 254)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Convert(converter = RoleConverter.class)
    @Column(name = "role", nullable = false)
    private UserRole role;

    public Users() {
    }

    public Users(Integer id) {
        super(id);
    }

    public Users(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public Users(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Users(Integer id, String login, String password, UserRole role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String email) {
        this.login = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Users users = (Users) o;
        return Objects.equals(login, users.login) && Objects.equals(password, users.password) && role == users.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, role);
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
