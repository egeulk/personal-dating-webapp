package com.example.simpledatingservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="answer_id")
    private long answerId;

    @Column(name="answer_content")
    private String answerContent;

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

}
