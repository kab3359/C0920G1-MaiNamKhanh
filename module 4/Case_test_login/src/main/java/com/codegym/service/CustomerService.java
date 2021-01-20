package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.entity.CustomerType;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(String id);
    Customer findById(String id);
    List<Customer> findByName(String name);
    List<Customer> findAllByCustomerType(CustomerType customerType);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
