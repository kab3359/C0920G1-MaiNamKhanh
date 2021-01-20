package com.codegym.service.impl;

import com.codegym.entity.City;
import com.codegym.repository.CityRepository;
import com.codegym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void delete(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City findById(int id) {
        return cityRepository.findById(id).orElse(null);
    }
}
