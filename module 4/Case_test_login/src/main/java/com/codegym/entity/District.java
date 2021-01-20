package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private Set<Ward> wards;

    @ManyToOne
    @JoinColumn(name = "city", nullable = false, referencedColumnName = "id")
    private City city;

    public District() {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
