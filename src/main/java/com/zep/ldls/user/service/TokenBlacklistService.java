package com.zep.ldls.user.service;

public interface TokenBlacklistService {

    void blacklistToken(String token);
    boolean isTokenBlacklisted(String token);
    void addToBlacklist(String token);
}
