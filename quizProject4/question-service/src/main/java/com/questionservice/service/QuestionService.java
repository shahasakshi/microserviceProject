package com.questionservice.service;

import com.questionservice.models.Question;
import com.questionservice.models.QuestionWrapper;
import com.questionservice.models.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface QuestionService {
    ResponseEntity <List<Question>> getAll();


    ResponseEntity< Question> saveQuestion(Question q);

   ResponseEntity< List<Question>> getQuestionByCategory(String category);

    String  deleteQuestionById(Integer id);

    ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numQuestions);

    ResponseEntity<List<QuestionWrapper>> getQuetionsFromId(List<Integer> questionIds);

    ResponseEntity<Integer> getScore(List<Response> responses);
}
