package com.cognologix.services;
import com.cognologix.dao.StudentRepository;
import com.cognologix.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudent(){
        List<Student>list1 = (List<Student>) this.studentRepository.findAll();
        return list1;
    }
    public Student getStudentById(int id) {
        Student student = this.studentRepository.findById(id);
        return student;
    }
    public Student addStudent(Student student){
        this.studentRepository.save(student);
        return student;
    }
    public  void deleteStudentById(int id) {
        this.studentRepository.deleteById(id);

    }
    public void updateStudent(Student student,int id) {
            student.setId(id);
            this.studentRepository.save(student);
    }

}
