package com.zep.ldls.user;

import java.util.Optional;

public interface Service {


    Optional<User> findByUsernameOrEmail(String username, String email);

    User convertDTOToUser(UserDTO userDTO);

    void addUser(UserDTO userDTO);

    User saveUser(User user);

    boolean isPasswordMatching(String username, String email, String password);

    boolean changePassword(String username, String email, String newPassword);

    void initiateFirstTimeLoginVerification(String username, String userEmail);

    boolean isFirstTimeLogin(String username, String userEmail);

    Optional<User> findById(Long id);

    void deleteUser(Long id);

    Iterable<User> getAllUsers();

    void verifyFirstTimeLoginOTP(String username, String otpCode);

    boolean isOTPVerificationEnabled(String username);

    void verifyFirstTimeLoginOTP(String username, String email, String otpCode);

    boolean isOTPVerificationEnabled(String username, String email);

    boolean changePasswordByUsername(String username, String newPassword);

    boolean changePasswordByEmail(String email, String newPassword);

    boolean sendResetPasswordInstructions(String username);

    Optional<User> findByUsername(String username);

    Object getOTP(String username);

    boolean toggleMFA();
}
