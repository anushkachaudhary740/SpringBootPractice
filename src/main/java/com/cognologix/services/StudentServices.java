package com.cognologix.services;
import com.cognologix.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentServices {
    private List<Student> list =new ArrayList<>();{
        list.add(new Student(11,"Mohan",100));
        list.add(new Student(12,"Dohan",200));
        list.add(new Student(13,"Sohan",300));
        list.add(new Student(14,"Rohan",400));
        list.add(new Student(15,"Hohan",500));
    }
    public List<Student> getAllStudent(){
        return list;
    }
    public Student getStudentById(int id) {
        Student student=null;
        student=list.stream().filter(e->e.getId()==id).findFirst().get();
        return student;
    }
    public void addStudent(Student student){
        list.add(student);
    }

    public void deleteStudentById(int id) {
        list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
    }

    public void updateStudent(Student student,int id) {
        list.stream().map(e->{
			if(e.getId()==id) {
				e.setName(student.getName());
				e.setMarks(student.getMarks());
			}
			return e;
		}).collect(Collectors.toList());
    }
}
