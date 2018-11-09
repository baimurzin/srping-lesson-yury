package com.example.srpinglesson.model;

import com.example.srpinglesson.security.roles.Roles;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "auth_users", schema = "\"user\"")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Size(min = 2, message = "Именя должно быть меньше 2 и больше 32 символов.",max = 32)
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    @Size(min = 5, message = "Пароль должен состоять не менее чем из 5 символов.")
    private String password;

    @Column(name = "email")
    @Email(message = "Не правильно заполненно поле email.")
    private String email;

    @Column(name = "active")
    private boolean active = true;

    @ElementCollection(targetClass = Roles.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", schema = "\"user\"", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

        public AuthUser() {
    }

    public AuthUser(@Size(min =2, max = 32) String login, @Size(min = 5) String password, @Email String email) {
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

    public Set<Roles> getRoles() {
        return roles;
    }

    public HashSet<Roles> getHashSetRoles(){
          return new HashSet<>(roles);
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
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
