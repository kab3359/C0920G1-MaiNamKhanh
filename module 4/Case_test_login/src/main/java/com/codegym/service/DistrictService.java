package com.codegym.service;

import com.codegym.entity.City;
import com.codegym.entity.District;

import java.util.List;

public interface DistrictService {
    List<District> findAll();
    void save(District district);
    void delete(int id);
    District findById(int id);
    List<District> findByCity(City city);
}
