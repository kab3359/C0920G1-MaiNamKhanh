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

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
