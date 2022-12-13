package com.example.simpledatingservice.DTO;

import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Question;

import java.util.List;

public class QuestionsDTO {

    private List<AnsweredQuestion> answeredQuestions;

    private List<Question> nonAnsweredQuestions;

    public List<AnsweredQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public List<Question> getNonAnsweredQuestions() {
        return nonAnsweredQuestions;
    }

    public void setNonAnsweredQuestions(List<Question> nonAnsweredQuestions) {
        this.nonAnsweredQuestions = nonAnsweredQuestions;
    }
}
