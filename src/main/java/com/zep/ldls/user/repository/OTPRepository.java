package com.zep.ldls.user.repository;

import com.zep.ldls.user.model.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface OTPRepository extends JpaRepository<OTP, Long> {
        OTP findOTPByUsername(String username);
    }

