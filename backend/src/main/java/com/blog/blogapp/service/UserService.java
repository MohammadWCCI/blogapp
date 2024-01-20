package com.blog.blogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blogapp.model.User;
import com.blog.blogapp.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public void signUp(User user) {
        // Add validation logic if needed
        // For simplicity, we're not hashing the password in this example
       
        userRepository.save(user);
    }

    public String login(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());

        if (userOptional.isPresent() && verifyPassword(user.getPassword(), userOptional.get().getPassword())) {
            // Authentication successful
            return "JWT_TOKEN"; // Replace with your actual token generation logic
        }

        return null; // Authentication failed
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private boolean verifyPassword(String inputPassword, String storedPassword) {
        // For simplicity, we're comparing passwords directly (not recommended for production)
        return inputPassword.equals(storedPassword);
    }
}
