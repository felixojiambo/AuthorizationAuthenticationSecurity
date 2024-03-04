package com.zep.ldls.user.service;
import com.zep.ldls.user.dto.UserDTO;
import com.zep.ldls.user.model.User;
import com.zep.ldls.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.zep.ldls.user.enums.Status;
@Service
public class RegistrationImpl implements Registration {


        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public void registerUser(UserDTO userDTO) {
            User user = convertDTOToUser(userDTO);
            user.setStatus(Status.PENDING);
            userRepository.save(user);
            sendEmailVerificationOTP(user);
        }

        @Override
        public boolean sendEmailVerificationOTP(User user) {

            return true;
        }

        @Override
        public boolean verifyEmailVerificationOTP(String username, String otp) {

            return otp.equals("123456");
        }

        @Override
        public void promoteToAdmin(User user) {
            user.setAdmin(true);
            userRepository.save(user);
        }



        @Override
        public void approveAdminRegistration(User user) {
            user.setStatus(Status.ACTIVE);
            userRepository.save(user);
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


