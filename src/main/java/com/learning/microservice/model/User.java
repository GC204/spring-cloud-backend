package com.learning.microservice.model;

import com.learning.microservice.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Enumerated(value=EnumType.STRING)
    @Column(name="role")
    private Role role;
}
