package com.codegym.exam.service.impl;

import com.codegym.exam.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll();
    Customer findById(long id);
    void save(Customer customer);
    void delete(long id);
}
