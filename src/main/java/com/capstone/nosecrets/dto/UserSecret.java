package com.capstone.nosecrets.dto;

public class UserSecret {

    private String secret;

    public UserSecret() {}

    public UserSecret(String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

}
