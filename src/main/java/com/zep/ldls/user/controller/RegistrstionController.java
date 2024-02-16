package com.zep.ldls.user.controller;

import com.zep.ldls.user.dto.UserDTO;
import com.zep.ldls.user.service.RegistrationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrstionController {

    @Autowired
    private RegistrationImpl registrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        registrationService.registerUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }
}

