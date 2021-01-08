package com.codegym.service;

import com.codegym.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
    void delete(int id);
    Student findById(int id);
    List<Student> findByName(String name);
}
