package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "service_type_id")
    private int id;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private Set<Service> services;

    @Column (name = "service_type_name")
    private String name;

    public ServiceType() {
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
