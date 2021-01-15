package com.codegym.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "service")
public class Service {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY, generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "com.codegym.common.MyGenerator")
    @Column (name = "service_id")
    private String id;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    @Column (name = "service_name")
    private String name;

    @Column (name = "service_area")
    private int area;

    @Column (name = "service_cost")
    private double cost;

    @Column (name = "service_max_people")
    private int maxPeople;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false, referencedColumnName = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false, referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @Column (name = "standard_room")
    private String standardRoom;

    @Column(name = "description")
    private String description;

    @Column(name = "pool_area")
    private double poolArea;

    @Column(name = "num_floor")
    private int numFloor;

    public Service() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }
}
