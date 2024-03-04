//package com.zep.ldls.user.controller;
//

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/otp")
//public class OTPController {
//
//    private final AuthenticationService authenticationService;
//
//    @Autowired
//    public OTPController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @PostMapping("/verify")
//    public String verifyOTP(@RequestBody OTPVerificationRequest otpRequest) {
//        // Validate OTP
//        boolean isOTPValid = authenticationService.verifyOTP(otpRequest.getUsername(), otpRequest.getOtp());
//
//        if (isOTPValid) {
//            return "OTP Verified successfully";
//        } else {
//            return "Invalid OTP";
//        }
//    }
//
//    @PostMapping("/toggle")
//    public String toggleOTPVerification(@RequestBody OTPVerificationRequest otpRequest) {
//        // Toggle OTP verification (assuming you have a service method for this)
//        boolean isOTPToggled = authenticationService.toggleOTPVerification(otpRequest.getUsername());
//
//        if (isOTPToggled) {
//            return "OTP Verification toggled successfully";
//        } else {
//            return "Failed to toggle OTP Verification";
//        }
//    }
//}
