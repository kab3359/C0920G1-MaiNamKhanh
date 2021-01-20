package com.codegym.service;

import com.codegym.entity.Employee;
import com.codegym.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    void save(Position position);
    void delete(int id);
    Position findById(int id);
}
