package com.example.AuthorizationService.repository;

import com.example.AuthorizationService.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    static {
        // Добавление тестовых пользователей с использованием перечисления Authorities
        users.add(new User("admin", "password", List.of(Authorities.READ, Authorities.WRITE)));
        users.add(new User("user", "userpass", List.of(Authorities.READ)));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (User  u : users) {
            if (u.getUser().equals(user) && u.getPassword().equals(password)) {
                return u.getAuthorities();
            }
        }
        return new ArrayList<>();
    }
}