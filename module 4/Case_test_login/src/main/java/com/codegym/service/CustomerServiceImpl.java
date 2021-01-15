package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.entity.CustomerType;
import com.codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }


    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Customer> findAllByCustomerType(CustomerType customerType) {
        return customerRepository.findAllByCustomerType(customerType);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findAllByAddressContaining(String name, Pageable pageable) {
        return customerRepository.findAllByAddressContaining(name, pageable);
    }

}
