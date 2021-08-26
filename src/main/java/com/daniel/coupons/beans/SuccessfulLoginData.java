package com.daniel.coupons.beans;

import com.daniel.coupons.enums.UserType;

public class SuccessfulLoginData {
    private String token;
    private UserType userType;

    public SuccessfulLoginData(String token, UserType userType) {
        this.token = token;
        this.userType = userType;
    }

    public SuccessfulLoginData() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}