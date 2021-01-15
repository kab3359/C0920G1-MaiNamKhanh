package com.codegym.service;

import com.codegym.entity.CustomerType;

import java.util.List;
import java.util.Optional;

public interface CustomerTypeService {
    List<CustomerType> findAll();
    CustomerType findById(int id);
}
