package com.cognologix.controller;
import com.cognologix.model.Student;
import com.cognologix.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @GetMapping("/get")
    public List<Student> findAllStudentDetails(){
        return this.studentServices.getAllStudent();
    }
    @GetMapping("/get/{id}")
    public Student findStudentDetailsById(@PathVariable("id") int id){
        return studentServices.getStudentById(id);

    }
    @PostMapping("/post")
    public Student createStudentDetails(@RequestBody Student student){
         this.studentServices.addStudent(student);
         return student;
    }
    @DeleteMapping("/delete/{id}")
    public void findAllStudentDetails(@PathVariable("id") int id){
        this.studentServices.deleteStudentById(id);
    }
    @PutMapping("/put/{id}")
    public Student updateStudentDetails(@RequestBody Student student,@PathVariable("id") int id){
        this.studentServices.updateStudent(student,id);
        return student;
    }

}
