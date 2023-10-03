package com.quizservice.service;

import com.quizservice.models.QuestionWrapper;
import com.quizservice.models.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {

    ResponseEntity<String> createQuiz(String category, int numQ, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id);

    ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
