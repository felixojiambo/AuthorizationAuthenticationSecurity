package com.zep.ldls.user.dto;

import lombok.Data;

@Data
public class ForgotPasswordRequest {

    private String email;


    public ForgotPasswordRequest(String email) {
        this.email = email;
    }


    public String getEmail() {
        return  email;
    }
}