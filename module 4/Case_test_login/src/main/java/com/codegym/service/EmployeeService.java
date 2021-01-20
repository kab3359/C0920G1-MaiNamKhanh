package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    void delete(int id);
    Employee findById(int id);
}
