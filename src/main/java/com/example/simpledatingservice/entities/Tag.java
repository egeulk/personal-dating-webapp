package com.example.simpledatingservice.entities;

import javax.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "tag_name")
    private String tagName;

}
