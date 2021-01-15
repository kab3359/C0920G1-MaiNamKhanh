package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "division")
public class Division {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "division_id")
    private int id;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private Set<Employee> employeeSet;

    @Column(name = "division_name")
    private String name;

    public Division() {
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
