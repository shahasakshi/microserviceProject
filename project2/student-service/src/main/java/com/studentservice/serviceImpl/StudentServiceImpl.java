package com.studentservice.serviceImpl;

import com.studentservice.model.Student;
import com.studentservice.model.StudentResult;
import com.studentservice.repo.StudentRepo;
import com.studentservice.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(String sId) {

        //get result from database using restTemplate
        Student student = studentRepo.findById(sId).get();

//        ArrayList<StudentResult> studentResult = restTemplate.getForObject("localhost:1002/result/result/"+student.getSId(),ArrayList.class);
//        logger.info("{}",studentResult);
//        student.setStudentResults(studentResult);

        return student;
    }

    @Override
    public String deleteStudentById(String sId) {
         studentRepo.deleteById(sId);
         return "delete sucessfully";
    }

    @Override
    public Student getByFirstName(String firstName) {
        Student student = studentRepo.findByFirstName(firstName);

        //get result by firstname save result in student service fetch all data from student service getByFirstName

        ArrayList<StudentResult> stuArray= restTemplate.getForObject("http://localhost:1002/result/firstName/"+student.getFirstName(),ArrayList.class);
        logger.info(" {} ",stuArray);
        student.setStudentResults(stuArray);

        return student;
    }
}
