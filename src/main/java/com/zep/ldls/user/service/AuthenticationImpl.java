//package com.zep.ldls.user.service;
//
//import com.zep.ldls.user.dto.LoginRequest;
//import com.zep.ldls.user.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//@Service
//public class AuthenticationImpl {
//    @Autowired
//    private UserServiceImpl userService; // Assuming you have a UserService or similar service to interact with user data
//
//    @Override
//    public UserDetails authenticateUser(LoginRequest loginRequest) {
//        return null;
//    }
//
//    @Override
//    public void initiateOTPVerification(OTPVerificationRequest otpVerificationRequest) {
//
//    }
//
//    @Override
//    public void changePassword(ChangePasswordRequest changePasswordRequest) {
//
//    }
//
//    @Override
//    public void registerUser(UserDTO userDTO) {
//
//    }
//
//    @Override
//    public boolean verifyOTP(String username, String otp) {
//        // Retrieve the user by username
//        Optional<Optional<User>> user = Optional.ofNullable(userService.findByUsername(username));
//        if (user != null) {
//
//            Optional<User> storedOTP = user.get();
//            return storedOTP != null && storedOTP.equals(otp);
//        }
//        return false; // User not found or OTP mismatch
//    }
//
//    @Override
//    public User getOTP(String username) {
//        // Retrieve the user by username
//        Optional<User> user = userService.findByUsername(username);
//        if (user != null) {
//            // Retrieve the OTP from the user object or database
//            return user.get();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean toggleOTPVerification(String username) {
//        return false;
//    }
//}
