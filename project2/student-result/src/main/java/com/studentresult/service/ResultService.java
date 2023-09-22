package com.studentresult.service;

import com.studentresult.model.StudentResult;

import java.util.List;

public interface ResultService {

    //save
    StudentResult save(StudentResult studentResult);

    //getAllResult
    List<StudentResult> getAllResult();

    //getResultByRid

    StudentResult getResultById(String rId);

    //getByName
    List<StudentResult> getByName(String firstName);
}
