package com.blog.blogapp.model;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Users")
@Entity(name = "Users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private Long id;

    private String username;
    private String password;
    private String email;
    // private String fullName;
    // private String aboutMe;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BlogPost> blogPosts = new HashSet<>();

    // Constructors, getters, and setters
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        // this.fullName = fullName;
        // this.aboutMe = aboutMe;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // public String getFullName() {
    //     return fullName;
    // }

    // public String getAboutMe() {
    //     return aboutMe;
    // }

    public Set<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setPassword(String password) {
        this.password = password;
        // You might want to hash the password before setting it
    }

    // Other utility methods

    public void addBlogPost(BlogPost blogPost) {
        blogPosts.add(blogPost);
        blogPost.setAuthor(this);
    }

    public void removeBlogPost(BlogPost blogPost) {
        blogPosts.remove(blogPost);
        blogPost.setAuthor(null);
    }

    // Override toString() for better logging or debugging
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                // ", fullName='" + fullName + '\'' +
                // ", aboutMe='" + aboutMe + '\'' +
                '}';
    }
}
