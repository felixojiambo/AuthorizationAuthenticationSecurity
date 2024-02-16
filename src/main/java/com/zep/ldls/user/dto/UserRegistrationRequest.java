package com.zep.ldls.user.dto;

import lombok.Data;


@Data
public class UserRegistrationRequest {
    // Getter and setter methods for username and email
    private String username;
    private String email;
    String phone;
    String password;

}
