package com.quizservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    //when we have number or specific collection go for ElemnetCollection
    @ElementCollection
    private List<Integer> questionsIds;
}
