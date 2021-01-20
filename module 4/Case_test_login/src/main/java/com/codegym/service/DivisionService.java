package com.codegym.service;

import com.codegym.entity.Division;
import com.codegym.entity.EducationDegree;

import java.util.List;

public interface DivisionService {
    List<Division> findAll();
    void save(Division division);
    void delete(int id);
    Division findById(int id);
}
