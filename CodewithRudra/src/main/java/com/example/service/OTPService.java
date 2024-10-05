package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class OTPService {

    public void sendOTP(String mobileNumber, String otp) {
        // Code to send OTP using Twilio or another SMS provider
    }

    public boolean verifyOTP(String inputOtp, String actualOtp) {
        return inputOtp.equals(actualOtp);
    }
}
