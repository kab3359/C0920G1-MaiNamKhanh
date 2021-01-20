package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<District> districts;

    @OneToMany(mappedBy = "city1", cascade = CascadeType.ALL)
    private Set<Customer> customers;

    public City() {
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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
