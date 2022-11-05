package com.cognologix.services;
import com.cognologix.dao.StudentRepository;
import com.cognologix.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;
    private List<Student> list =new ArrayList<>();{
        list.add(new Student(11,"Mohan",100));
        list.add(new Student(12,"Dohan",200));
        list.add(new Student(13,"Sohan",300));
        list.add(new Student(14,"Rohan",400));
        list.add(new Student(15,"Hohan",500));
    }
    public List<Student> getAllStudent(){
        List<Student> list1=null;
        try {

            list1 = (List<Student>) this.studentRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list1;
    }
    public Student getStudentById(int id) {
            Student student = null;
        try {
            student = this.studentRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;

    }
    public Student addStudent(Student student){
        try {
            this.studentRepository.save(student);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public String  deleteStudentById(int id) {
        this.studentRepository.deleteById(id);
        return "Data ";
    }

    public void updateStudent(Student student,int id) {
            student.setId(id);
            this.studentRepository.save(student);
    }
}
