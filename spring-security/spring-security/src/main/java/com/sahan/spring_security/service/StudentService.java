package com.sahan.spring_security.service;

import com.sahan.spring_security.model.Student;
import com.sahan.spring_security.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;


    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }

    public boolean addStudent(Student student) {
        return repo.addStudent(student);
    }

    public boolean updateStudent(Student student, int id) {
        return repo.updateStudent(student,id);
    }

    public String deleteStudent(int id) {
        return repo.deleteStudent(id);
    }
}
