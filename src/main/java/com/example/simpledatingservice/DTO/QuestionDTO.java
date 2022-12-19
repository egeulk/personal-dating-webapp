package com.example.simpledatingservice.DTO;

import com.example.simpledatingservice.entities.Answer;


import java.util.List;

public class QuestionDTO {

    private String content;

    private List<Answer> possibleAnswers;

    private Answer chosenAnswer;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public Answer getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(Answer chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }
}
