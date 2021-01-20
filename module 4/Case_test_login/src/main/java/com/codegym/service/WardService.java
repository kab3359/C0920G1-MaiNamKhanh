package com.codegym.service;

import com.codegym.entity.District;
import com.codegym.entity.Ward;

import java.util.List;

public interface WardService {
    List<Ward> findAll();
    void save(Ward ward);
    void delete(int id);
    Ward findById(int id);
}
