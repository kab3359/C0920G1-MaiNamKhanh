package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "user")
public class User {
    @Id
    @Column (name = "username")
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @Column (name = "password")
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

}
