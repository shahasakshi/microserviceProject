package com.studentservice.repo;

import com.studentservice.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student,String> {

    Student findByFirstName(String firstName);
}
