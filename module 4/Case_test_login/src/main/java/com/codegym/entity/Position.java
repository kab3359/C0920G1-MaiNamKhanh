package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "position")
public class Position {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "position_id")
    private int id;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private Set<Employee> employees;


    @Column(name = "position_name")
    private String name;

    public Position() {
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
