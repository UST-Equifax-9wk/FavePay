package com.Revpay.FavePay.entities;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "passwords")
@Table(indexes = {@Index(columnList = "username")})
public class Auth {
    @Id
    @Column(name = "auth")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auth;

    @Column(name = "username", unique = true)
    private String username;

    @Column
    private String password;

    public Auth() {
    }

    public Auth(Integer auth, String username, String password) {
        this.auth = auth;
        this.username = username;
        this.password = password;
    }

    public Auth(Integer auth) {
        this.auth = auth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
