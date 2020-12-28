package com.codegym.service;

import com.codegym.model.Customer;

import java.sql.*;
import java.util.*;

public class CustomerDao {


    private static final Map<Integer, Customer> listCUSTOMER = new HashMap<Integer, Customer>();

    static {
        initCustomers();
    }

    private static void initCustomers() {
        Customer cus1 = new Customer(1, "Mai Nam Khánh", "123456789", "abc@abc.abc");
        Customer cus2 = new Customer(2, "Nguyễn Công Trí", "11111111", "bcd@abc.abc");
        Customer cus3 = new Customer(3, "Trần Quang Đạo", "222222222", "abc@abc.com");
        Customer cus4 = new Customer(4, "Nguyễn Thị Thu Sương", "123121123", "abc@abc.net");

        listCUSTOMER.put(cus1.getId(), cus1);
        listCUSTOMER.put(cus2.getId(), cus2);
        listCUSTOMER.put(cus3.getId(), cus3);
        listCUSTOMER.put(cus4.getId(), cus4);
    }

    public static Customer getCustomer(int customerId){
        return listCUSTOMER.get(customerId);
    }

    public static void addCustomer(Customer customer){
        listCUSTOMER.put(customer.getId(), customer);
    }

    public static Customer updateAndCreateCustomer (Customer customer){
        listCUSTOMER.put(customer.getId(), customer);
        return customer;
    }

    public static void deleteCustomer(int customerId){
        listCUSTOMER.remove(customerId);
    }

    public static List<Customer> getAllCustomer(){
//        Collection<Customer> c = listCUSTOMER.values();
//        List<Customer> list = new ArrayList<Customer>();
//        list.addAll(c);
//        return list;
        Collection<Customer> c = listCUSTOMER.values();
        return new ArrayList<>(c);
    }


}
