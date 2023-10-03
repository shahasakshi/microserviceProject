
package com.quizservice.serviceImpl;

import com.quizservice.feign.QuizInterface;
import com.quizservice.models.QuestionWrapper;
import com.quizservice.models.Quiz;
import com.quizservice.models.Response;
import com.quizservice.repo.QuizRepo;
import com.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    QuizInterface quizInterface;


    @Override
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Quiz quiz =  quizRepo.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestion(questionIds);

        return questions;
    }

    @Override

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
