package com.codegym.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY, generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "com.codegym.common.MyGenerator")
    @Column(name = "customer_id")
    private String id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    @Column (name = "customer_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false, referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @Column (name = "customer_birthday")
    private Date date;

    @Column (name = "customer_gender")
    private boolean gender;

    @Column (name = "customer_id_card")
    private String idCard;

    @Column (name = "customer_phone")
    private String phone;

    @Column (name = "customer_email")
    private String email;

    @Column (name = "customer_address")
    private String address;

    public Customer() {
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
