package com.codegym.service.impl;

import com.codegym.entity.EducationDegree;
import com.codegym.repository.EducationDegreeRepository;
import com.codegym.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void delete(int id) {
        educationDegreeRepository.deleteById(id);
    }

    @Override
    public EducationDegree findById(int id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }
}
