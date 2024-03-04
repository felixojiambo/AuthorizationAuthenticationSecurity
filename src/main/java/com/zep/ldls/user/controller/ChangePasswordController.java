//package com.zep.ldls.user.controller;
//
//import com.zep.ldls.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/change-password")
//public class ChangePasswordController {
//
//    private final UserService userService;
//
//    @Autowired
//    public ChangePasswordController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
//        // Get the authenticated user's email or username
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String identifier = authentication.getName();
//
//        // Check if the identifier is an email or username
//        if (identifier.contains("@")) {
//            // Identifier is an email
//            return changePasswordByEmail(identifier, changePasswordRequest.getNewPassword());
//        } else {
//            // Identifier is a username
//            return changePasswordByUsername(identifier, changePasswordRequest.getNewPassword());
//        }
//    }
//
//    private ResponseEntity<String> changePasswordByUsername(String username, String newPassword) {
//        // Call UserService to change password by username
//        boolean passwordChanged = userService.changePasswordByUsername(username, newPassword);
//
//        if (passwordChanged) {
//            return ResponseEntity.ok("Password changed successfully");
//        } else {
//            return ResponseEntity.badRequest().body("Failed to change password");
//        }
//    }
//
//    private ResponseEntity<String> changePasswordByEmail(String email, String newPassword) {
//        // Call UserService to change password by email
//        boolean passwordChanged = userService.changePasswordByEmail(email, newPassword);
//
//        if (passwordChanged) {
//            return ResponseEntity.ok("Password changed successfully");
//        } else {
//            return ResponseEntity.badRequest().body("Failed to change password");
//        }
//    }
//}
//
//
//
///*package com.LDLS.controller;
//
//import com.LDLS.dto.ChangePasswordRequest;
//import com.LDLS.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/change-password")
//public class ChangePasswordController {
//
//    private final UserService userService;
//
//    @Autowired
//    public ChangePasswordController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
//        // Get the authenticated user
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//
//        // Change password logic based on your requirements
//        boolean passwordChanged = userService.changePassword(username,email, changePasswordRequest.getNewPassword());
//
//        if (passwordChanged) {
//            return ResponseEntity.ok("Password changed successfully");
//        } else {
//            return ResponseEntity.badRequest().body("Failed to change password");
//        }
//    }
//}
//*/