package vn.codegym.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import vn.codegym.model.Student;

import java.util.List;

@Service
public class abc implements StudentService {
    @Override
    public List<Student> findAll() {
        return null;
    }
}
