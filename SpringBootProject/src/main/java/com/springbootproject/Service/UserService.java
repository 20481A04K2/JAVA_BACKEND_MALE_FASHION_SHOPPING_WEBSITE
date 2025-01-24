package com.springbootproject.Service;

import com.springbootproject.Entity.User;
import com.springbootproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Sign Up
    public String signUp(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "User already exists!";
        }
        userRepository.save(user);
        return "Registration successful!";
    }

    // Sign In
    public String signIn(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            return "Sign In Successful!";
        }
        return "Invalid credentials!";
    }

    // Check if User Exists
    public boolean checkIfUserExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
