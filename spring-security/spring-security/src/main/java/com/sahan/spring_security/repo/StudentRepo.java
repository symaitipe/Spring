package com.sahan.spring_security.repo;

import com.sahan.spring_security.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    List<Student> allStudentsList = new ArrayList<>();


    public List<Student> getAllStudents() {
        return allStudentsList;
    }

    public boolean addStudent(Student student) {
        return allStudentsList.add(student);
    }

    public boolean updateStudent(Student student, int id) {
        boolean updateStatus = false;

        for (Student s: allStudentsList){
            System.out.println("passed id is : "+id+" Compare with "+s.getId());
            if(s.getId()==id){
                s.setName(student.getName());
                s.setAge(student.getAge());
                s.setTech(student.getTech());
                return updateStatus = true;
            }else{
                 updateStatus = false;
            }
        }
        return updateStatus;
    }

    public String deleteStudent(int id) {
        String deleteStatus= "failed";
        for (Student s:allStudentsList){
            if(s.getId() ==id) {
                allStudentsList.remove(id-1);
                deleteStatus = "success";
                break;
            }
        }
        return deleteStatus;
    }
}
