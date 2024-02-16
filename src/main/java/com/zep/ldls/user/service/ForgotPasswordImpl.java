package com.zep.ldls.user.service;
import com.zep.ldls.user.dto.ForgotPasswordRequest;
import com.zep.ldls.user.model.User;
import com.zep.ldls.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ForgotPasswordImpl implements ForgotPassword {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender emailSender;

    @Autowired
    public ForgotPasswordImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JavaMailSender emailSender) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSender = emailSender;
    }

    @Override
    public void initiateForgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        String usernameOrEmail = forgotPasswordRequest.getEmail();
        Optional<User> userOptional = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
        userOptional.ifPresent(user -> {
            sendPasswordResetEmail(user);
            // You can perform additional actions if needed, such as logging, updating user status, etc.
        });
    }

    @Override
    public void initiatePasswordReset(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        userOptional.ifPresent(this::sendPasswordResetEmail);
        // You can perform additional actions if needed, such as logging, updating user status, etc.
    }

    @Override
    public boolean verifyOTP(String username, String otp) {
        // Dummy implementation, replace with actual OTP verification logic
        return otp.equals("123456");
    }

    @Override
    public void resetPassword(String username, String newPassword) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        userOptional.ifPresent(user -> {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            // You can perform additional actions if needed, such as logging, updating user status, etc.
        });
    }

    @Override
    public boolean confirmNewPassword(String username, String newPassword, String confirmPassword) {
        // Simple implementation to check if newPassword and confirmPassword match
        return newPassword.equals(confirmPassword);
    }

    private void sendPasswordResetEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Password Reset");
        message.setText("Please click the following link to reset your password: resetpassword.com");
        emailSender.send(message);
    }
}



