package com.example.simpledatingservice.service;

import com.example.simpledatingservice.DTO.AnswerQuestionDTO;
import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Question;
import com.example.simpledatingservice.repository.AnsweredQuestionsRepository;
import com.example.simpledatingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class AnsweredQuestionService {
    private AnsweredQuestionsRepository answeredQuestionsRepository;

    private UserRepository userRepository;
    @Autowired
    public AnsweredQuestionService(AnsweredQuestionsRepository answeredQuestionsRepository){
        this.answeredQuestionsRepository = answeredQuestionsRepository;
    }


    @Transactional
    public List<AnsweredQuestion> getAnsweredQuestions(Long id){
        return answeredQuestionsRepository.findByUser_Id(id);
    }

    public List<Question> getUnansweredQuestions(Long id){
        return answeredQuestionsRepository.findNonAnsweredQuestions(id);
    }

    public void answerQuestion(AnswerQuestionDTO answer, Long questionId, Long userId) {
        if (answer.getAnswer().getAnswerContent().isEmpty()) {
            answeredQuestionsRepository.deleteByQuestion_IdAndUser_Id(answer.getQuestionId(), answer.getUserId());
        }
        else {
            // answeredQuestionsRepository.save(answeredQuestion);
            // what happens if a user answers the same question twice?
            // should user_id + question_id be the id?
        }
    }




}
