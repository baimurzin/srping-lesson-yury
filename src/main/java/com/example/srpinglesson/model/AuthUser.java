package com.example.srpinglesson.model;

import com.example.srpinglesson.security.roles.Roles;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authUsers", schema = "\"user\"")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Min(value = 2, message = "Именя должно быть больше 2 символов.")
    @Max(value = 32, message = "Именя должно быть меньше 32 символов.")
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    @Min(value = 5, message = "Пароль должен состоять не менее чем из 5 символов.")
    private String password;

    @Column(name = "email")
    @Email(message = "Не правильно заполненно поле email.")
    private String email;

    @Column(name = "active")
    boolean active;

    @ElementCollection(targetClass = Roles.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", schema = "\"user\"", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

    public AuthUser() {
    }

    public AuthUser(@Min(2) @Max(32) String login, @Min(5) String password, @Email String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUser authUser = (AuthUser) o;
        return id == authUser.id &&
                Objects.equals(login, authUser.login) &&
                Objects.equals(password, authUser.password) &&
                Objects.equals(email, authUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email);
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}