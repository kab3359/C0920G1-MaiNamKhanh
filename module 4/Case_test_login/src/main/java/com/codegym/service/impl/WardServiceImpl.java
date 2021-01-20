package com.codegym.service.impl;

import com.codegym.entity.Ward;
import com.codegym.repository.WardRepository;
import com.codegym.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WardServiceImpl implements WardService {
    @Autowired
    WardRepository wardRepository;
    @Override
    public List<Ward> findAll() {
        return wardRepository.findAll();
    }

    @Override
    public void save(Ward ward) {
        wardRepository.save(ward);
    }

    @Override
    public void delete(int id) {
        wardRepository.deleteById(id);
    }

    @Override
    public Ward findById(int id) {
        return wardRepository.findById(id).orElse(null);
    }
}
