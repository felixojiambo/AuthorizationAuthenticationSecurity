package com.zep.ldls.user.controller;

import com.zep.ldls.user.dto.ForgotPasswordRequest;
import com.zep.ldls.user.dto.ResetPasswordRequest;
import com.zep.ldls.user.service.ForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ForgotPasswordController {

    private final ForgotPassword forgotPassword;

    @Autowired
    public ForgotPasswordController(ForgotPassword forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> initiateForgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        forgotPassword.initiateForgotPassword(forgotPasswordRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Password reset initiated successfully");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOTP(@RequestParam String username, @RequestParam String otp) {
        boolean otpVerified = forgotPassword.verifyOTP(username, otp);
        if (otpVerified) {
            return ResponseEntity.status(HttpStatus.OK).body("OTP verified successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String username, @RequestBody ResetPasswordRequest resetPasswordRequest) {
        if (resetPasswordRequest.getNewPassword().equals(resetPasswordRequest.getConfirmPassword())) {
            forgotPassword.resetPassword(username, resetPasswordRequest.getNewPassword());
            return ResponseEntity.status(HttpStatus.OK).body("Password reset successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("New password and confirm password do not match");
        }
    }

}

