package com.codegym.service;

import com.codegym.entity.EducationDegree;
import com.codegym.entity.Position;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();
    void save(EducationDegree educationDegree);
    void delete(int id);
    EducationDegree findById(int id);
}
