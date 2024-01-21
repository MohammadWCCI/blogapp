package com.blog.blogapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import com.blog.blogapp.model.User;
import com.blog.blogapp.repo.UserRepository;
import com.blog.blogapp.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
@Secured({"ROLE_USER"})
@RequestMapping("/api/users")
public class UserController {
    
    UserService userService;
    @Autowired
    UserRepository userRepository;



    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        // Add validation and password hashing logic in the service
        User createdUser = new User(user.getUsername(),  user.getPassword(), user.getEmail(), user.getFullName());
        userRepository.save(createdUser);
        return ResponseEntity.ok("User signed up successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Implement authentication logic in the service
        // Return a JWT token upon successful login
        String token = userService.login(user);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

    @GetMapping("/about-me/{username}")
    public ResponseEntity<User> aboutMe(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
