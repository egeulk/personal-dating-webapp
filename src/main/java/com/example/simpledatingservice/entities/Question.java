package com.example.simpledatingservice.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToMany
    @JoinColumn(name="question_id")
    private List<Answer> possibleAnswers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }


}
