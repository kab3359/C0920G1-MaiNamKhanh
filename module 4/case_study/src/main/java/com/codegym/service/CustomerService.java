package com.codegym.service;

import com.codegym.entity.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(String id);
    Customer findById(String id);
    List<Customer> findByName(String name);
}
