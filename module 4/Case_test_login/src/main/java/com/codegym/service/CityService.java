package com.codegym.service;

import com.codegym.entity.City;
import com.codegym.entity.Position;

import java.util.List;

public interface CityService {
    List<City> findAll();
    void save(City city);
    void delete(int id);
    City findById(int id);
}
