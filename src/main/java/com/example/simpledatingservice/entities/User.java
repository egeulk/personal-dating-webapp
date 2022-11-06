package com.example.simpledatingservice.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name="surname")
    private String surname;

    //enumeration could be added for pronouns and genders
    //https://stackoverflow.com/questions/2751733/map-enum-in-jpa-with-fixed-values

    @Column(name="user_pronoun")
    private String pronoun;

    @Column(name="user_gender")
    private String gender;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = CascadeType.REFRESH)
    @JoinTable(
            name="users_tags",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    private List<Tag> tags;


}
