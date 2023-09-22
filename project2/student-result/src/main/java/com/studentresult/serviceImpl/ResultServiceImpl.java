package com.studentresult.serviceImpl;

import com.studentresult.model.StudentResult;
import com.studentresult.repo.ResultRepo;
import com.studentresult.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepo resultRepo;
    @Override
    public StudentResult save(StudentResult studentResult) {
        return resultRepo.save(studentResult);
    }

    @Override
    public List<StudentResult> getAllResult() {
        return resultRepo.findAll();
    }

    @Override
    public StudentResult getResultById(String rId) {
        return resultRepo.findById(rId).get();
    }

    @Override
    public List<StudentResult> getByName(String firstName) {
        return resultRepo.findByFirstName(firstName);
    }


}
