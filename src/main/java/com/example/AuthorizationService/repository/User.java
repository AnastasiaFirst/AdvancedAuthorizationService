package com.example.AuthorizationService.repository;

import com.example.AuthorizationService.Authorities;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

public class User {

    @NotBlank
    @Size(min = 3, max = 15)
    private String user;

    @NotBlank
    @Size(min = 6, max = 15)
    private String password;
    private List<Authorities> authorities;

    public User(String user, String password, List<Authorities> authorities) {
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }

    public User() {
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(user, user1.user) && Objects.equals(password, user1.password) && Objects.equals(authorities, user1.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password, authorities);
    }
}