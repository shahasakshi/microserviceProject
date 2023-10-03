package com.studentresult.repo;

import com.studentresult.model.StudentResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface ResultRepo extends MongoRepository<StudentResult ,String> {

    List<StudentResult> findByFirstName(String firstName);
}
