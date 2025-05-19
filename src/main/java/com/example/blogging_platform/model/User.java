package com.example.blog.model;  

import jakarta.persistence.*;  
import lombok.Data;  
import java.util.Set;  

@Data  
@Entity  
@Table(name = "users")  
public class User {  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  

    @Column(nullable = false, unique = true)  
    private String username;  

    @Column(nullable = false, unique = true)  
    private String email;  

    @Column(nullable = false)  
    private String password;  

    @Enumerated(EnumType.STRING)  
    @Column(nullable = false)  
    private Role role;  

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)  
    private Set<Post> posts;  

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)  
    private Set<Comment> comments;  
}  
