package session_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> listStudents = new ArrayList<Student>();
        listStudents.add(new Student(1, "Vinh", 19, "Hanoi"));
        listStudents.add(new Student(2, "Hoa", 19, "Danang"));
        listStudents.add(new Student(3, "Vinh", 20, "Hue"));
        listStudents.add(new Student(4, "Quy", 22, "Quangnam"));
        Collections.sort(listStudents);
        for (Student student : listStudents) {
            System.out.println(student.toString());
        }
    }
}
