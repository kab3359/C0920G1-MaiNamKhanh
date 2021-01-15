package com.codegym.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue (generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "com.codegym.common.MyGenerator")
    @Column(name = "customer_id")
    private String id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    @Column (name = "customer_name")
    @NotBlank
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
    @Pattern(regexp = "[0-9]{5}", message = "phone ko đúng định dạng")
    private String phone;

    @Column (name = "customer_email")
    @Email(message = "email sai định dạng")
    private String email;

    @Column (name = "customer_address")
    private String address;

    @Column (name = "customer_picture")
    private String picture;

    public Customer() {
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
