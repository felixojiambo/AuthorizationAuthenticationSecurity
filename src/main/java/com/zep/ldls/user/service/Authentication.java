//package com.zep.ldls.user.service;
//
//import com.zep.ldls.user.dto.ChangePasswordRequest;
//import com.zep.ldls.user.dto.LoginRequest;
//import com.zep.ldls.user.dto.OTPVerificationRequest;
//import com.zep.ldls.user.dto.UserDTO;
//import com.zep.ldls.user.model.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public interface Authentication {
//    UserDetails authenticateUser(LoginRequest loginRequest);
//    void initiateOTPVerification(OTPVerificationRequest otpVerificationRequest);
//    void changePassword(ChangePasswordRequest changePasswordRequest);
//    void registerUser(UserDTO userDTO); // Assuming you have a UserDTO class for user registration
//
//    boolean verifyOTP(String username, String otp);
//    User getOTP(String username);
//
//    boolean toggleOTPVerification(String username);
//
//  ;
//}
