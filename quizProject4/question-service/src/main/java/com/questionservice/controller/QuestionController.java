
package com.questionservice.controller;


import com.questionservice.models.Question;
import com.questionservice.models.QuestionWrapper;
import com.questionservice.models.Response;
import com.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    Environment environment;
    @GetMapping ("/getAllQ")
    public ResponseEntity< List<Question>> getAllQuestion(){
        return new ResponseEntity ( questionService.getAll(), HttpStatus.OK);
    }

    //save
    @PostMapping("/add")
    public ResponseEntity< Question> saveQuestion(@RequestBody Question q)
    {
        return questionService.saveQuestion(q);
    }

    //getByCategories
    @GetMapping("/category/{category}")
    public ResponseEntity< List<Question>> getByCategory(@PathVariable String category)
    {
        return questionService.getQuestionByCategory(category);
    }

    //deleteById
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestionById(id);
    }

    //generate q
    //get q
    //result

    @GetMapping("generateQ")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions){
      return questionService.getQuestionForQuiz(categoryName,numQuestions);
    }
  //getQ
    @PostMapping("getQuestion")
     public ResponseEntity<List<QuestionWrapper>> getQuestion(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuetionsFromId(questionIds);
    }

    //getScore

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}
