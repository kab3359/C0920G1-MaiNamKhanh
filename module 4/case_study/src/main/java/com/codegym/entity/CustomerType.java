package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "customer_type_id")
    private int id;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Customer> customers;

    @Column (name = "customer_type_name")
    private String name;

    public CustomerType() {
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
