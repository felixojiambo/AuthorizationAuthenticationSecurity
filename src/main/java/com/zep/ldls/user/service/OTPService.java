package com.zep.ldls.user.service;

import com.zep.ldls.user.model.OTP;
import com.zep.ldls.user.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    @Autowired
    private OTPRepository otpRepository;

    public String retrieveOTPByUsername(String username) {
        // Assuming you have a method in your OTPRepository to find OTP by username
        OTP otp = otpRepository.findOTPByUsername(username);
        if (otp != null) {
            return otp.getValue();
        } else {
            return null; // Or throw an exception if OTP is not found
        }
    }
}

