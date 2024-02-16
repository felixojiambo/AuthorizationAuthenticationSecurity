//package com.zep.ldls.user.controller;
//
//
//import com.emtech.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/mfa-toggle")
//@PreAuthorize("hasRole('ADMIN')")
//public class MFAToggleController {
//
//    private final UserService userService;
//
//    @Autowired
//    public MFAToggleController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> toggleMFA() {
//        // Toggle OTP verification (multiple-factor authentication) for users
//        boolean mfaToggled = userService.toggleMFA();
//
//        if (mfaToggled) {
//            return ResponseEntity.ok("MFA toggled successfully");
//        } else {
//            return ResponseEntity.badRequest().body("Failed to toggle MFA");
//        }
//    }
//}
