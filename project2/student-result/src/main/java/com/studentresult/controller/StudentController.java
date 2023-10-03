package com.studentresult.controller;

import com.studentresult.model.StudentResult;
import com.studentresult.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("result")
public class StudentController {

    @Autowired
    ResultService resultService;

    //save
    @PostMapping("save")
    public StudentResult saveResult(@RequestBody StudentResult studentResult){
        return resultService.save(studentResult);
    }

    //getAllResult
    @GetMapping("getAll")
    public List<StudentResult> getAllResult(){
        return resultService.getAllResult();
    }

    //getByRid
    @GetMapping("result/{rId}")
    public StudentResult getResultById(@PathVariable String rId){
        return resultService.getResultById(rId);
    }

    //findbyname
    @GetMapping("firstName/{firstName}")
    public List<StudentResult> getByFirstName(@PathVariable String firstName){
        return resultService.getByName(firstName);
    }
}
