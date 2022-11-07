package com.cognologix.controller;
import com.cognologix.model.Student;
import com.cognologix.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @GetMapping("/get")
    public ResponseEntity<List<Student>> findAllStudentDetails(){
        List<Student>list=null;
        try {
            list = this.studentServices.getAllStudent();
            if (list.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> findStudentDetailsById(@PathVariable("id") int id){
        Student stu=null;
        try {
            stu = studentServices.getStudentById(id);
            if (stu == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.of(Optional.of(stu));

    }
    @PostMapping("/post")
    public ResponseEntity<Student> createStudentDetails(@RequestBody Student student){
         Student st=null;
         try {
             st=this.studentServices.addStudent(student);
             return ResponseEntity.of(Optional.of(st));
         }catch (Exception e){
             e.printStackTrace();
         }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> findAllStudentDetails(@PathVariable("id") int id){
        try {
            this.studentServices.deleteStudentById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Data Deleted........");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student,@PathVariable("id") int id){
        try {
            this.studentServices.updateStudent(student, id);
            return ResponseEntity.ok().body(student);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
