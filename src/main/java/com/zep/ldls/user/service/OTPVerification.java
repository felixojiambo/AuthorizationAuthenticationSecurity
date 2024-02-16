package com.zep.ldls.user.service;

public interface OTPVerification {
    String generateOTP();

    void sendOTP(String username, String destination);

    void generateAndSendOTP(String username, String destination);

    boolean verifyOTP(String username, String otpCode);
}
