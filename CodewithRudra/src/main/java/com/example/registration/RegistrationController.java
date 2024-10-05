package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.OTPService;
import com.example.service.UserService;
import com.example.model.User;  // Make sure to import your custom User class

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private OTPService otpService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        // Add Aadhaar verification logic if needed
        userService.registerUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/verifyMobile")
    public String verifyMobile(@RequestParam String mobileNumber, @RequestParam String otp) {
        User user = userService.findByMobileNumber(mobileNumber);
        if (user != null && otpService.verifyOTP(otp, "123456")) { // Replace "123456" with the actual OTP logic
            user.setMobileVerified(true);  // Directly call the method on the user object
            userService.registerUser(user);
            return "Mobile verified!";
        }
        return "Invalid OTP!";
    }
}
