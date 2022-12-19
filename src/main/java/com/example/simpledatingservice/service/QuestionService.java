package com.example.simpledatingservice.service;

import com.example.simpledatingservice.DTO.QuestionDTO;
import com.example.simpledatingservice.entities.Question;
import com.example.simpledatingservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public Question getQuestionById(Long id){
        Question question = questionRepository.findById(id).get();
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setContent(question.getContent());
        questionDTO.setPossibleAnswers(question.getPossibleAnswers());
        return question;
    }

    public List<Question> getAllQuestions() {
        List<Question> result = new ArrayList<Question>();
        Iterable<Question> iterable = questionRepository.findAll();
        iterable.forEach(result::add);
        return result;
    }

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
