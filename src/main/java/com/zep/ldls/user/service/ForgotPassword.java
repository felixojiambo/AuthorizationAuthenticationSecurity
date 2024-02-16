package com.zep.ldls.user.service;

import com.zep.ldls.user.dto.ForgotPasswordRequest;

public interface ForgotPassword {

    void initiateForgotPassword(ForgotPasswordRequest forgotPasswordRequest);


    void initiatePasswordReset(String username);


    boolean verifyOTP(String username, String otp);

    void resetPassword(String username, String newPassword);

    boolean confirmNewPassword(String username, String newPassword, String confirmPassword);
}
