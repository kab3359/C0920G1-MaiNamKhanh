package com.codegym.service.impl;

import com.codegym.entity.Division;
import com.codegym.repository.DivisionRepository;
import com.codegym.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void delete(int id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public Division findById(int id) {
        return divisionRepository.findById(id).orElse(null);
    }
}
