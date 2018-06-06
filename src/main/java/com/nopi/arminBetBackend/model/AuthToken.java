package com.nopi.arminBetBackend.model;

public class AuthToken {
    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public AuthToken setToken(String token) {
        this.token = token;
        return this;
    }
}
