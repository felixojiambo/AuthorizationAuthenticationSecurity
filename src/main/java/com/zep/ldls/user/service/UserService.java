package com.zep.ldls.user.service;
import com.zep.ldls.user.dto.UserDTO;
import com.zep.ldls.user.model.User;

import java.util.Optional;

public interface UserService {




              //  void registerUser(UserDTO userDTO);

                boolean sendOtpForVerification(User user);

                boolean verifyOtp(String username, String otp);

                void initiateForgotPassword(String username);

                boolean resetPasswordWithOtp(String username, String otp, String newPassword);

                void promoteToAdmin(User user);

                void sendAdminInvitation(String email);

                void approveAdminRegistration(User user);

                Optional<User> findByUsernameOrEmail(String username, String email);

                User saveUser(User user);

                Optional<User> findById(Long id);

                void deleteUser(Long id);

                Iterable<User> getAllUsers();

                boolean changePasswordByUsername(String username, String newPassword);

                boolean changePasswordByEmail(String email, String newPassword);

                boolean sendResetPasswordInstructions(String username);

                Optional<User> findByUsername(String username);

                Object getOTP(String username);

                boolean toggleMFA();
        }

