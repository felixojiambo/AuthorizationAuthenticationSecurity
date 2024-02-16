
package com.zep.ldls.user.controller;

import com.zep.ldls.user.dto.LogoutRequest;
import com.zep.ldls.user.service.Logout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogoutController {

    private final Logout logoutService;

    @Autowired
    public LogoutController(Logout logoutService) {
        this.logoutService = logoutService;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestBody LogoutRequest logoutRequest) {
        logoutService.logout(logoutRequest.getToken());
        return ResponseEntity.ok("Logged out successfully");
    }
}






















//package com.zep.ldls.user.controller;
//
//import com.zep.ldls.user.service.Logout;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class LogoutController {
//
//    private final Logout logoutService;
//
//    @Autowired
//    public LogoutController(Logout logoutService) {
//        this.logoutService = logoutService;
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<String> logoutUser(HttpServletRequest request) {
//        String token = extractToken(request);
//        if (token != null) {
//            logoutService.invalidateToken(token);
//        }
//        return ResponseEntity.ok("Logged out successfully");
//    }
//
//    private String extractToken(HttpServletRequest request) {
//
//        String authorizationHeader = request.getHeader("Authorization");
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            return authorizationHeader.substring(7); // Remove "Bearer " prefix
//        }
//
//
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("jwtToken".equals(cookie.getName())) {
//                    return cookie.getValue();
//                }
//            }
//        }
//
//        return null;
//
//}}
