package com.studentservice.model;


import org.springframework.data.annotation.Id;


public class StudentResult {
    private String rId;
    private String firstName;
    private float math;
    private float science;
    private float english;
    private float marathi;
    private float hindi;
    private float socialScience;

    public StudentResult() {
    }

    public StudentResult(String rId, String firstName, float math, float science, float english, float marathi, float hindi, float socialScience) {
        this.rId = rId;
        this.firstName = firstName;
        this.math = math;
        this.science = science;
        this.english = english;
        this.marathi = marathi;
        this.hindi = hindi;
        this.socialScience = socialScience;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getScience() {
        return science;
    }

    public void setScience(float science) {
        this.science = science;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getMarathi() {
        return marathi;
    }

    public void setMarathi(float marathi) {
        this.marathi = marathi;
    }

    public float getHindi() {
        return hindi;
    }

    public void setHindi(float hindi) {
        this.hindi = hindi;
    }

    public float getSocialScience() {
        return socialScience;
    }

    public void setSocialScience(float socialScience) {
        this.socialScience = socialScience;
    }

    @Override
    public String toString() {
        return "StudentResult{" +
                "rId='" + rId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", math=" + math +
                ", science=" + science +
                ", english=" + english +
                ", marathi=" + marathi +
                ", hindi=" + hindi +
                ", socialScience=" + socialScience +
                '}';
    }
}
