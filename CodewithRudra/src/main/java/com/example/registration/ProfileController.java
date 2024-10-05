package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.UserService;
import com.example.model.User; // Import your custom User class here

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public String updateProfile(@RequestBody User user) {
        // Fetch the user and update necessary details
        User existingUser = userService.findByMobileNumber(user.getMobileNumber());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            userService.registerUser(existingUser);
            return "Profile updated successfully!";
        }
        return "User not found!";
    }
}
