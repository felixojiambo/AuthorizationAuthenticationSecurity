package com.zep.ldls.user.service;

import com.zep.ldls.user.dto.LoginRequest;
import com.zep.ldls.user.model.User;

public interface Login {



    void login(LoginRequest loginRequest);
    boolean authenticate(String username, String password);

    String generateOTP();

    boolean sendTwoFactorAuthenticationOTP(User user);

    boolean verifyTwoFactorAuthenticationOTP(String username, String otp);


    void generateJwtToken(User user);
}

