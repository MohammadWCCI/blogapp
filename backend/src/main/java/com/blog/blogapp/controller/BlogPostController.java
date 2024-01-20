package com.blog.blogapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.blogapp.model.BlogPost;
import com.blog.blogapp.service.BlogPostService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/blogposts")
public class BlogPostController {
   
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
        List<BlogPost> blogPosts = blogPostService.getBlogPostsByUser(username);
        return ResponseEntity.ok(blogPosts);
    }
}
