package com.codegym.repository;

import com.codegym.entity.Customer;
import com.codegym.entity.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findAllByNameContaining(String name);
    List<Customer> findAllByCustomerType(CustomerType customerType);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
    Page<Customer> findAllByAddressContaining(String name, Pageable pageable);
}
