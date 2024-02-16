package com.zep.ldls.user.dto;

import lombok.Data;

@Data
public class ResetPasswordRequest {

    private String email;
    private String newPassword;
private  String confrimedPassword;

    public ResetPasswordRequest(String email, String newPassword,String confrimedPassword) {
        this.email = email;
        this.newPassword = newPassword;
        this.confrimedPassword=confrimedPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confrimedPassword;
    }
}