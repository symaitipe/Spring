package com.sahan.spring_security.controller;

import com.sahan.spring_security.model.Student;
import com.sahan.spring_security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return service.getAllStudents();
    }


    @PostMapping("/students")
    public boolean addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public boolean updateStudent(@RequestBody Student student,@PathVariable("id") int id){
        return service.updateStudent(student,id);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        return service.deleteStudent(id);
    }
}
