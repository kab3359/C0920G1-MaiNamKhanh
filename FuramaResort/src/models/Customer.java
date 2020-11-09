package models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
   String name;
   String dateOfBirth;
   String gender;
   String cmnd;
   String phone;
   String email;
   String special;
   String address;
   Services services;
   private ArrayList listCustomer = new ArrayList();
   public Customer(){};

    public Customer(String name, String dateOfBirth, String gender, String cmnd,
                    String phone, String email, String special, String address, Services services) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phone = phone;
        this.email = email;
        this.special = special;
        this.address = address;
        this.services = services;
    }
    public void addCustomer(){
        int idCustomer = (listCustomer.size() > 0) ? (listCustomer.size() + 1) : 1;
        System.out.println("product id = " + idCustomer);
    }
}
