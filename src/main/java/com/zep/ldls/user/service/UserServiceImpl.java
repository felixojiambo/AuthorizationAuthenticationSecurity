package com.zep.ldls.user.service;
import com.zep.ldls.user.enums.Status;
import com.zep.ldls.user.dto.UserDTO;
import com.zep.ldls.user.model.User;
import com.zep.ldls.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

 @Autowired
 private final UserRepository userRepository;

 @Autowired
 private final PasswordEncoder passwordEncoder;

 @Autowired
 private JavaMailSender emailSender;

 public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JavaMailSender emailSender) {
  this.userRepository = userRepository;
  this.passwordEncoder = passwordEncoder;
  this.emailSender = emailSender;
 }

// @Override
// public void registerUser(UserDTO userDTO) {
//  User user = convertDTOToUser(userDTO);
// // user.setStatus(User.Status.PENDING);
//  userRepository.save(user);
//  sendRoleAssignmentNotificationToAdmin(user);
// }

 @Override
 public boolean sendOtpForVerification(User user) {
  SimpleMailMessage message = new SimpleMailMessage();
  message.setTo(user.getEmail());
  message.setSubject("OTP Verification");
  message.setText("Your OTP for verification is: 123456");
  emailSender.send(message);
  return true;
 }

 @Override
 public boolean verifyOtp(String username, String otp) {
  return otp.equals("123456");
 }

 @Override
 public void initiateForgotPassword(String username) {
  Optional<User> optionalUser = userRepository.findByUsername(username);
  optionalUser.ifPresent(user -> {
   SimpleMailMessage message = new SimpleMailMessage();
   message.setTo(user.getEmail());
   message.setSubject("Forgot Password");
   message.setText("Please click the following link to reset your password: resetpassword.com");
   emailSender.send(message);
  });
 }

 @Override
 public boolean resetPasswordWithOtp(String username, String otp, String newPassword) {
  if (verifyOtp(username, otp)) {
   Optional<User> optionalUser = userRepository.findByUsername(username);
   if (optionalUser.isPresent()) {
    User user = optionalUser.get();
    user.setPassword(passwordEncoder.encode(newPassword));
    userRepository.save(user);
    return true;
   }
  }
  return false;
 }

 @Override
 public void promoteToAdmin(User user) {
  user.setAdmin(true);
  userRepository.save(user);
 }

 @Override
 public void sendAdminInvitation(String email) {
  SimpleMailMessage message = new SimpleMailMessage();
  message.setTo(email);
  message.setSubject("Admin Invitation");
  message.setText("You have been invited to register as an admin.");
  emailSender.send(message);
 }

 @Override
 public void approveAdminRegistration(User user) {
 //user.setStatus(User.Status.ACTIVE);
  userRepository.save(user);
 }

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        Optional<User> userByUsername = userRepository.findByUsername(username);
        if (userByUsername.isPresent()) {
            return userByUsername;
        } else {
            return userRepository.findByEmail(email);
        }
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean changePasswordByUsername(String username, String newPassword) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean changePasswordByEmail(String email, String newPassword) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean sendResetPasswordInstructions(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            initiateForgotPassword(username);
            return true;
        }
        return false;
    }


 private void sendRoleAssignmentNotificationToAdmin(User user) {
  SimpleMailMessage message = new SimpleMailMessage();
  message.setTo("admin@example.com");
  message.setSubject("New User Registration: Role Assignment Required");
  message.setText("A new user has registered with username: " + user.getUsername() +
          ". Please assign roles and permissions to this user.");
  emailSender.send(message);
 }
 @Override
 public Optional<User> findByUsername(String username) {
  return userRepository.findByUsername(username);
 }

    @Override
    public Object getOTP(String username) {
        return null;
    }

    @Override
    public boolean toggleMFA() {
        return false;
    }
    private User convertDTOToUser(UserDTO userDTO) {
  User user = new User();
  user.setUsername(userDTO.getUsername());
  user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
  user.setEmail(userDTO.getEmail());
  user.setPhoneNumber(userDTO.getPhoneNumber());
  return user;
 }
}
