package com.zep.ldls.user.service;

import com.zep.ldls.user.dto.UserDTO;
import com.zep.ldls.user.model.User;
import com.zep.ldls.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserProfileServiceImpl  implements UserProfileService {
    private final UserRepository userRepository;

    @Autowired
    public UserProfileServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateUserProfile(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(userDTO.getUsername());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setPhoneNumber(userDTO.getPhoneNumber());

            userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with username: " );
        }
    }

    @Override
    public void deleteUserProfile(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            userRepository.delete(user);
        } else {
            throw new EntityNotFoundException("User not found with username: " + username);
        }
    }

    @Override
    public UserDTO getUserProfile(String username) {
        return null;
    }
}
