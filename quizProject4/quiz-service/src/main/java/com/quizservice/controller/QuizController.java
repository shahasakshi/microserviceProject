package com.quizservice.controller;

import com.quizservice.models.QuestionWrapper;
import com.quizservice.models.QuizDto;
import com.quizservice.models.Response;
import com.quizservice.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //createQuiz
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
     return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQ(),quizDto.getTitle());
    }

    //getquiz
    @GetMapping("get/{id}")

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
         return quizService.getQuizQuestion(id);
    }

    //submit ans
    @PostMapping("submit/{id}")
     public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses)
    {
        return quizService.calculateResult(id,responses);
    }
}
