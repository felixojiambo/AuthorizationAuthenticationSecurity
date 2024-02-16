package com.zep.ldls.user.service;

import com.zep.ldls.user.dto.UserDTO;

public interface UserProfileService {
    void updateUserProfile(UserDTO userDTO);
    void deleteUserProfile(String username);

    UserDTO getUserProfile(String username);
}
