package com.cognologix.dao;
import com.cognologix.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

//CrudRepository use to perform all db operations
@Component
public interface StudentRepository extends CrudRepository<Student,Integer> {
    public Student findById(int id);
}