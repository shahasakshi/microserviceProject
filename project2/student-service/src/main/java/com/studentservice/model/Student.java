package com.studentservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;



@Document(collection = "StudentService")
public class Student {
    @Id
    private String sId;
    private String firstName;

    private String lastName;
    private Integer standard;

    @Transient
    private List<StudentResult> studentResults=new ArrayList<>();

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public List<StudentResult> getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(List<StudentResult> studentResults) {
        this.studentResults = studentResults;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", standard=" + standard +
                ", studentResults=" + studentResults +
                '}';
    }

    public Student() {

    }

    public Student(String sId, String firstName, String lastName, Integer standard, List<StudentResult> studentResults) {
        this.sId = sId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.standard = standard;
        this.studentResults = studentResults;
    }
}
