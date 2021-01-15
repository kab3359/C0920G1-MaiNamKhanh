package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "education_degree_id")
    private int id;

    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @Column(name = "education_degree_name")
    private String name;

    public EducationDegree() {
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
