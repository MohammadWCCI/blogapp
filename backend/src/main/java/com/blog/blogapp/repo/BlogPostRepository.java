package com.blog.blogapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogapp.model.BlogPost;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    // Custom query method to find all blog posts by a specific user
    List<BlogPost> findByAuthor_Username(String username);

    // You can add additional query methods as needed
}
