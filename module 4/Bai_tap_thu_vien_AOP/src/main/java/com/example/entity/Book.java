package com.example.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "book")
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<Contract> contracts;

    public Book() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
