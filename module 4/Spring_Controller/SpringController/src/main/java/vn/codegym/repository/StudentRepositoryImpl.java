package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nguyen Van A"));
        studentList.add(new Student(2, "Nguyen Van B"));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }
}
