package com.example.simpledatingservice.controller;

import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Tag;
import com.example.simpledatingservice.entities.User;
import com.example.simpledatingservice.service.AnsweredQuestionService;
import com.example.simpledatingservice.service.TagService;
import com.example.simpledatingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private AnsweredQuestionService answeredQuestionService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;



    @GetMapping("/getTags")
    public List<Tag> getAllTags(){
       return  tagService.getTags();
    }

    @GetMapping("/getUser/")
    public User getUserFromId() {
        User user = userService.getUser();
        System.out.println(user.getAnsweredQuestion());
        return user;
    }


    @GetMapping("/getAnsweredQuestions")
    public List<AnsweredQuestion> getAnsweredQuestions(){
        List<AnsweredQuestion> answeredQ = answeredQuestionService.getAnsweredQuestions();
        System.out.println(answeredQ);
        return answeredQ;

    }





}
