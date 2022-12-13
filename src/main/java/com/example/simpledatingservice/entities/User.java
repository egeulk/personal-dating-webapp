package com.example.simpledatingservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {
    public User() {
    }


    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    @JsonBackReference
    private UsersLogin usersLogin;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "user_pronoun")
    @Enumerated(EnumType.ORDINAL)
    private Gender orientation;

    @Column(name = "user_gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    public enum Gender {
        GENDER_MEN("Men"),
        GENDER_WOMEN("Women"),
        GENDER_OTHER("Other");

        private final String text;

        /**
         * @param text
         */
        Gender(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public String getGender() {
        return gender.toString();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGenderAsString(String gender) {
        this.gender = Gender.valueOf(gender);
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

    public UsersLogin getUsersLogin() {
        return usersLogin;
    }

    public void setUsersLogin(UsersLogin usersLogin) {
        this.usersLogin = usersLogin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrientation() {
        return orientation.toString();
    }

    public void setOrientation(Gender orientation) {
        this.orientation = orientation;
    }

    public void setOrientationAsString(String gender) {
        this.orientation = Gender.valueOf(gender);
    }
}