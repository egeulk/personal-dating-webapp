package com.example.simpledatingservice.service;

import com.example.simpledatingservice.DTO.AnswerQuestionDTO;
import com.example.simpledatingservice.entities.Answer;
import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Question;
import com.example.simpledatingservice.entities.User;
import com.example.simpledatingservice.repository.AnswerRepository;
import com.example.simpledatingservice.repository.AnsweredQuestionsRepository;
import com.example.simpledatingservice.repository.QuestionRepository;
import com.example.simpledatingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnsweredQuestionService {
    private AnsweredQuestionsRepository answeredQuestionsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    public AnsweredQuestionService(AnsweredQuestionsRepository answeredQuestionsRepository){
        this.answeredQuestionsRepository = answeredQuestionsRepository;
    }


    @Transactional
    public List<AnsweredQuestion> getAnsweredQuestions(Long id){
        return answeredQuestionsRepository.findByUser_Id(id);
    }
    @Transactional
    public List<Question> getUnansweredQuestions(Long id){
        return answeredQuestionsRepository.findNonAnsweredQuestions(id);
    }
    @Transactional
    public Answer getUsersAnswer(Long userId, Long questionId){
        return   answeredQuestionsRepository.findAnswerByUserAndQuestionId(userId, questionId);
    }

    @Transactional
    public void answerQuestion(AnswerQuestionDTO answerDTO, Long userId) {
        if (answerDTO.getAnswer().getAnswerId() == -1) {
            answeredQuestionsRepository.deleteByQuestion_IdAndUser_Id(answerDTO.getQuestionId(), answerDTO.getUserId());
        }
        else {
            AnsweredQuestion answered = answeredQuestionsRepository.findByQuestion_IdAndUser_Id(answerDTO.getQuestionId(), userId);
            if(answered==null) {
                AnsweredQuestion answeredQuestion = new AnsweredQuestion();
                answeredQuestion.setAnswer(answerRepository.findById(answerDTO.getAnswer().getAnswerId()).get());
                answeredQuestion.setImportance(answerDTO.getImportance());
                answeredQuestion.setUser(userRepository.findById(userId).get());
                answeredQuestion.setQuestion(questionRepository.findById(answerDTO.getQuestionId()).get());
                answeredQuestionsRepository.save(answeredQuestion);
            }
            else {
                answered.setImportance(answerDTO.getImportance());
                answered.setAnswer(answerRepository.findById(answerDTO.getAnswer().getAnswerId()).get());
                answeredQuestionsRepository.save(answered);
            }
        }
    }




}
