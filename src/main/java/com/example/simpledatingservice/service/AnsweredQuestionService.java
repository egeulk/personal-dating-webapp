package com.example.simpledatingservice.service;

import com.example.simpledatingservice.DTO.AnswerQuestionDTO;
import com.example.simpledatingservice.entities.Answer;
import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Question;
import com.example.simpledatingservice.entities.User;
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

    public Answer getUsersAnswer(Long userId, Long questionId){
        return   answeredQuestionsRepository.findAnswerByUserAndQuestionId(userId, questionId);
    }

    public void answerQuestion(AnswerQuestionDTO answerDTO, Long userId) {
        if (answerDTO.getAnswer().getAnswerContent().isEmpty()) {
            answeredQuestionsRepository.deleteByQuestion_IdAndUser_Id(answerDTO.getQuestionId(), answerDTO.getUserId());
        }
        else {
            AnsweredQuestion answered = answeredQuestionsRepository.findByQuestion_IdAndUser_Id(answerDTO.getQuestionId(), userId);
            if(answered==null) {
                AnsweredQuestion answeredQuestion = new AnsweredQuestion();
                answeredQuestion.setAnswer(answerDTO.getAnswer());
                answeredQuestion.setImportance(answerDTO.getImportance());
                User user = new User();
                user.setId(userId);
                answeredQuestion.setUser(user);
                answeredQuestionsRepository.save(answeredQuestion);
            }
            else {
                answeredQuestionsRepository.save(answered);
                answeredQuestionsRepository.updateAnswerAndImportanceByUserAndQuestion(answerDTO.getAnswer(), answerDTO.getImportance(), answerDTO.getQuestionId(), userId);

            }
        }
    }




}
