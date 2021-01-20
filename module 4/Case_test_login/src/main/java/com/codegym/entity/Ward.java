package com.codegym.entity;

import javax.persistence.*;

@Entity
@Table(name = "ward")
public class Ward {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "district", nullable = false, referencedColumnName = "id")
    private District district;

    public Ward() {
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
