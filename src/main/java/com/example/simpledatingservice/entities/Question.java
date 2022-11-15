package com.example.simpledatingservice.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToMany(mappedBy = "question")
    private List<Answer> possibleAnswers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
