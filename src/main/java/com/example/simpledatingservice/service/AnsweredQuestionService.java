package com.example.simpledatingservice.service;

import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Question;
import com.example.simpledatingservice.entities.Tag;
import com.example.simpledatingservice.repository.AnsweredQuestionsRepository;
import com.example.simpledatingservice.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AnsweredQuestionService {
    private AnsweredQuestionsRepository answeredQuestionsRepository;
    @Autowired
    public AnsweredQuestionService(AnsweredQuestionsRepository answeredQuestionsRepository){
        this.answeredQuestionsRepository = answeredQuestionsRepository;
    }



    public List<AnsweredQuestion> getAnsweredQuestions(){
        List<AnsweredQuestion> result = new ArrayList<AnsweredQuestion>();
        Iterable<AnsweredQuestion> iterable = answeredQuestionsRepository.findAll();
        iterable.forEach(result::add);
        return result;
    }

    public Question getUnansweredQuestions(){
        return answeredQuestionsRepository.findNonAnsweredQuestions();
    }



}
