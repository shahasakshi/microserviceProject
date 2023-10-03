package com.quizservice.models;

import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer numQ;
    String title;
}
