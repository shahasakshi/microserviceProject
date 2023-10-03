package com.studentservice.service;

import com.studentservice.model.Student;
import com.studentservice.serviceImpl.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    //save
    Student saveStudent(Student student);

    //getAllStudent
    List<Student> getAllStudent();

    //getStudentById
    Student getStudentById(String sId);

    //deleteStudentById
     String deleteStudentById(String sId);

     //getByFirstName

    Student getByFirstName(String firstName) ;
}
