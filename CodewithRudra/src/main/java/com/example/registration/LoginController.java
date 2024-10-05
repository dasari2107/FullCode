package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.UserService;
import com.example.model.User;  // Ensure you're importing your own User class

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String mobileNumber, @RequestParam String aadhaarNumber) {
        User user = userService.findByMobileNumber(mobileNumber);
        if (user != null && user.getAadhaarNumber().equals(aadhaarNumber) && user.isMobileVerified()) {
            // Logic to generate session/token (can be JWT or session management)
            return "Login successful!";
        }
        return "Invalid credentials!";
    }
}
