package com.example.simpledatingservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    //enumeration could be added for pronouns and genders
    //https://stackoverflow.com/questions/2751733/map-enum-in-jpa-with-fixed-values

    @Column(name = "user_pronoun")
    private String pronoun;

    @Column(name = "user_gender")
    private String gender;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "users_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<AnsweredQuestion> answeredQuestion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<AnsweredQuestion> getAnsweredQuestion() {
        return answeredQuestion;
    }

    public void setAnsweredQuestion(List<AnsweredQuestion> answeredQuestion) {
        this.answeredQuestion = answeredQuestion;
    }

}