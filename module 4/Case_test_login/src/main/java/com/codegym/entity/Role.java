package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "role")
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "role_id")
    private int id;

    @Column (name = "role_name")
    private String name;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "role_user",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "username"))
    private Set<User> users;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
