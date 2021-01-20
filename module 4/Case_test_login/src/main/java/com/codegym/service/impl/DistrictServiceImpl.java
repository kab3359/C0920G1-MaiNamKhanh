package com.codegym.service.impl;

import com.codegym.entity.City;
import com.codegym.entity.District;
import com.codegym.repository.DistrictRepository;
import com.codegym.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictRepository districtRepository;
    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public void save(District district) {
        districtRepository.save(district);
    }

    @Override
    public void delete(int id) {
        districtRepository.deleteById(id);
    }

    @Override
    public District findById(int id) {
        return districtRepository.findById(id).orElse(null);
    }

    @Override
    public List<District> findByCity(City city) {
        return districtRepository.findAllByCity(city);
    }
}
