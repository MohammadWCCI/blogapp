package com.blog.blogapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blogapp.model.BlogPost;
import com.blog.blogapp.repo.BlogPostRepository;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
     BlogPostRepository blogPostRepository;



    public void createBlogPost(BlogPost blogPost) {
        // Add validation logic if needed
            blogPostRepository.save(blogPost);

        
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public List<BlogPost> getBlogPostsByUser(String username) {
        return blogPostRepository.findByAuthor_Username(username);
    }
}
