package com.questionservice.serviceImpl;

import com.questionservice.models.Question;
import com.questionservice.models.QuestionWrapper;
import com.questionservice.models.Response;
import com.questionservice.service.QuestionService;
import com.questionservice.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.*;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    //getall
    @Override
    public ResponseEntity< List<Question>>getAll() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
//save
    @Override
    public ResponseEntity< Question> saveQuestion(Question q) {
        return new ResponseEntity<>( questionRepo.save(q),HttpStatus.CREATED);
    }

    //getbycATEGORY
    @Override
    public ResponseEntity< List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>( questionRepo.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }

       return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
//deletById
    @Override
    public String  deleteQuestionById(Integer id) {
         questionRepo.deleteById(id);
         return "deleted succesfully";
    }

    @Override
    public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = questionRepo.findRandomQuestionByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuetionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for(Integer id: questionIds){
            questions.add(questionRepo.findById(id).get());
        }

        for(Question q:questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(q.getId());
            wrapper.setQuestionTitle(q.getQuestionTitle());
            wrapper.setOption1(q.getOption1());
            wrapper.setOption2(q.getOption2());
            wrapper.setOption3(q.getOption3());
            wrapper.setOption4(q.getOption4());
            wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int result = 0;
        for(Response response : responses){
            Question question = questionRepo.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                result++;
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}


