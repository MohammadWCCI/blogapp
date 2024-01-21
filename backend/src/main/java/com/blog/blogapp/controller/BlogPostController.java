package com.blog.blogapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.blogapp.model.BlogPost;
import com.blog.blogapp.model.User;
import com.blog.blogapp.repo.UserRepository;
import com.blog.blogapp.service.BlogPostService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/blogposts")
public class BlogPostController {
    
    @Autowired
    UserRepository userRepository;
    BlogPostService blogPostService;


    @PostMapping("/create")
    public ResponseEntity<String> createBlogPost(@RequestBody BlogPost blogPost) {
        // Add validation and additional logic in the service
        blogPostService.createBlogPost(blogPost);
        return ResponseEntity.ok("Blog post created successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return ResponseEntity.ok(blogPosts);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<BlogPost>> getBlogPostsByUser(@PathVariable String username) {
        List<BlogPost> blogPosts = userRepository.findByUsername(username).map(user -> {
            return blogPostService.getBlogPostsByUser(user);
        }).orElseThrow(() -> new EntityNotFoundException("User Not Found: "+username+" Not Found"));

        return new ResponseEntity<>(blogPosts, HttpStatus.OK);
    }
}
