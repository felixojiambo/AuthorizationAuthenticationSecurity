package com.zep.ldls.user.service;

import org.springframework.stereotype.Service;

@Service
public class LogoutImpl implements Logout {
    private final TokenBlacklistService tokenBlacklistService;
    public LogoutImpl(TokenBlacklistService tokenBlacklistService) {
        this.tokenBlacklistService = tokenBlacklistService;
    }
    @Override
    public void logout(String token) {
            tokenBlacklistService.addToBlacklist(token);

    }
}
