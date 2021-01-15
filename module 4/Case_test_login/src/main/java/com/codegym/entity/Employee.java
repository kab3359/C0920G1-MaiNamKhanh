package com.codegym.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "employee_id")
    private int id;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    @Column (name = "employee_name")
    private String name;

    @Column (name = "employee_birthday")
    private Date birthday;

    @Column (name = "employee_id_card")
    private String idCard;

    @Column (name = "employee_salary")
    private Double salary;

    @Column (name = "employee_phone")
    private String phone;

    @Column (name = "employee_email")
    private String email;

    @Column (name = "employee_address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false, referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false, referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false, referencedColumnName = "username")
    private User user;

    public Employee() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
