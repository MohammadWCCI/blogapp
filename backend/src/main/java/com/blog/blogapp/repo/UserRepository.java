package com.blog.blogapp.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogapp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    // You can add additional query methods as needed
}
