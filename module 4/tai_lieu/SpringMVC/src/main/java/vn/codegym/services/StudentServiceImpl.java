package vn.codegym.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import vn.codegym.model.Student;
import vn.codegym.repository.StudentRepository;
import vn.codegym.repository.StudentRepositoryImpl;

import java.util.List;

@Service
@Primary
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
