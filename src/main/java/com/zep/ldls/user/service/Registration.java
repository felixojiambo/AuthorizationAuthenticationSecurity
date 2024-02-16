package com.zep.ldls.user.service;

import com.zep.ldls.user.dto.UserDTO;
import com.zep.ldls.user.model.User;

public interface Registration {

    void registerUser(UserDTO userDTO);

    //void sendAdminInvitation(String email);

    boolean sendEmailVerificationOTP(User user);

    boolean verifyEmailVerificationOTP(String username, String otp);

    void promoteToAdmin(User user);

    void approveAdminRegistration(User user);

    public interface RegistrationService {
        void registerUser(UserDTO userDTO);
    }
}
