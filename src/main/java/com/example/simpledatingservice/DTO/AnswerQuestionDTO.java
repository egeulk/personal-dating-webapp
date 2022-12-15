package com.example.simpledatingservice.DTO;

import com.example.simpledatingservice.entities.Answer;
import com.example.simpledatingservice.entities.Question;
import com.example.simpledatingservice.entities.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

public class AnswerQuestionDTO {

    private long questionId;

    private Answer answer;

    private long userId;

    private short importance;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public short getImportance() {
        return importance;
    }

    public void setImportance(short importance) {
        this.importance = importance;
    }
}
