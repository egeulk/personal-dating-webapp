package com.example.simpledatingservice.DTO;

import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Tag;

import javax.persistence.Column;
import java.util.List;

public class UserDTO {
    private String name;

    private String surname;

    private String pronoun;

    private String gender;

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

}
