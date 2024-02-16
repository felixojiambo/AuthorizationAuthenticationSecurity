package com.zep.ldls.user.service;
import com.zep.ldls.user.model.TokenBlacklist;
import com.zep.ldls.user.repository.TokenBlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

    @Service
    public class TokenBlacklistImpl implements TokenBlacklistService {

        private final TokenBlacklistRepository blacklistRepository;

        @Autowired
        public TokenBlacklistImpl(TokenBlacklistRepository blacklistRepository) {
            this.blacklistRepository = blacklistRepository;
        }

        @Override
        public void blacklistToken(String token) {
            TokenBlacklist blacklist = new TokenBlacklist();
            blacklist.setToken(token);
            blacklistRepository.save(blacklist);
        }

        @Override
        public boolean isTokenBlacklisted(String token) {
            Optional<TokenBlacklist> optionalBlacklist = blacklistRepository.findByToken(token);
            return optionalBlacklist.isPresent();
        }
        @Override
        public void addToBlacklist(String token) {
            TokenBlacklist blacklist = new TokenBlacklist();
            blacklist.setToken(token);
            blacklistRepository.save(blacklist);
        }

    }


