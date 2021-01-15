package com.codegym.service;

import com.codegym.entity.Student;
import com.codegym.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
       this.studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
      this.studentRepository.deleteById(id);
    }

    @Override
    public Student findById(int id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findByName(String name) {
        return this.studentRepository.findAllByNameContaining(name);
    }


}
