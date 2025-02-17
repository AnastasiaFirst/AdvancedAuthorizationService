package com.example.AuthorizationService.controller;

import com.example.AuthorizationService.Authorities;
import com.example.AuthorizationService.annotation.UserCredentials;
import com.example.AuthorizationService.repository.UserRepository;
import com.example.AuthorizationService.repository.User;
import com.example.AuthorizationService.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;
    private final UserRepository userRepository;

    @Autowired
    public AuthorizationController(AuthorizationService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@UserCredentials User user) {
        return service.getAuthorities(user.getUser(), user.getPassword());
    }
}