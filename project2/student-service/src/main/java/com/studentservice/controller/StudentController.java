package com.studentservice.controller;

import com.studentservice.model.Student;
import com.studentservice.service.StudentService;
import com.studentservice.serviceImpl.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //save
    @PostMapping("save")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    //getAllStudent
    @GetMapping("getAll")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    //getStudentById
    @GetMapping("getStudent/{sId}")
    public Student getStudentById(@PathVariable String sId){
        return studentService.getStudentById(sId);
    }

    //deleteStudentById
    @DeleteMapping("delete/{sId}")
    public String deleteStudentById(@PathVariable String sId){
        return studentService.deleteStudentById(sId);
    }

    //getByFirstName
    @GetMapping("name/{firstName}")
    public Student getByFirstName(@PathVariable String firstName) throws StudentNotFoundException {
        return studentService.getByFirstName(firstName);
    }




}
