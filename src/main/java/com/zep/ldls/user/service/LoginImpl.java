package com.zep.ldls.user.service;
import com.zep.ldls.user.dto.LoginRequest;
import com.zep.ldls.user.model.User;
import com.zep.ldls.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.zep.ldls.user.util.JwtTokenUtil;

import java.util.Random;

@Service
public class LoginImpl implements Login {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
   // private final SMSService smsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final JavaMailSender emailSender;

    @Autowired
    public LoginImpl(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtTokenUtil jwtTokenUtil,JavaMailSender emailSender ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
this.emailSender=emailSender;
    }

    @Override
    public void login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            String jwtToken = jwtTokenUtil.generateToken((UserDetails) user);

        } else {
            throw new RuntimeException("Authentication failed: Incorrect username or password");
        }
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public String generateOTP() {

        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }
//@Override
//public boolean sendTwoFactorAuthenticationOTP(User user) {
//    String otp = generateOTP();
//    SimpleMailMessage message = new SimpleMailMessage();
//    message.setTo(user.getEmail());
//    message.setSubject("OTP Verification");
//    message.setText("Your OTP for verification is: " + otp);
//   emailSender.send(message);
//    // Assuming we have a method to send OTP to phone number as well
//    smsService.sendOTP(user.getPhoneNumber(), otp);
//     sendOTPToPhoneNumber(user.getPhoneNumber(), otp);
//    return true;
//}
//
    @Override
    public boolean verifyTwoFactorAuthenticationOTP(String username, String otp) {

            return otp.equals("123456");
        }

@Autowired
private SMSService smsService;

    @Override
    public boolean sendTwoFactorAuthenticationOTP(User user) {
        String otp = generateOTP();
        sendOTPViaEmail(user.getEmail(), otp); // Send OTP via email
        sendOTPViaSMS(user.getPhoneNumber(), otp); // Send OTP via SMS
        return true;
    }

    private void sendOTPViaEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP Verification");
        message.setText("Your OTP for verification is: " + otp);
        emailSender.send(message);
    }

    private void sendOTPViaSMS(String phoneNumber, String otp) {
        smsService.sendOTP(phoneNumber, otp);
    }

    @Override
    public void generateJwtToken(User user) {

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.getAuthorities());


        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());


        SecurityContextHolder.getContext().setAuthentication(authentication);


        String  jwtToken = jwtTokenUtil.generateToken(userDetails);
    }

}

