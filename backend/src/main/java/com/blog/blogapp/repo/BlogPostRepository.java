package com.blog.blogapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.blogapp.model.BlogPost;
import com.blog.blogapp.model.User;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    // Custom query method to find all blog posts by a specific user
    List<BlogPost> findByAuthor(User author);
}
