package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "rent_type_id")
    private int id;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private Set<Service> services;


    @Column(name = "rent_type_name")
    private String name;

    @Column(name = "rent_type_cost")
    private Double cost;

    public RentType() {
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
