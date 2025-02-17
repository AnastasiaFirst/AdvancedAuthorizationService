package com.example.AuthorizationService.exception;

public class UnauthorizedUser  extends RuntimeException {
    public UnauthorizedUser (String msg) {
        super(msg);
    }
}