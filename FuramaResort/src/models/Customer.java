package models;

import controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String ID;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String cmnd;
    private String phone;
    private String email;
    private String type;
    private String address;
    private Services services;
   public Customer(){};

    public Customer(String ID, String name, String dateOfBirth, String gender, String cmnd,
                    String phone, String email, String type, String address) {
        this.ID = ID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void showInfo(){
        System.out.println("ID: " + getID() + "| name: " + name + "| dateOfBirth: " + dateOfBirth + "| gender: " + gender
                + "| cmnd: " + cmnd + "| phone: " + phone + "| email: " + email + "| type: " + type + "| address: " + address);
    }
    public String writeFile(){
        return ID + "," + name + "," + dateOfBirth + "," + gender + "," + cmnd + "," + phone + "," + email + "," + type + "," + address;
    }
}
