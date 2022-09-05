package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Oleg Sazonov", 5, 8);
        Student st2 = new Student("Aleksandra Lysenko", 4, 8.2);
        Student st3 = new Student("Vladislav Yurovsky", 2, 7.2);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("Start of working getStudents() method");
//        System.out.println(students.get(3));
        System.out.println("Information from method getStudents:");
        System.out.println(students);
        return students;
    }
}
