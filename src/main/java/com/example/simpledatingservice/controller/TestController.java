package com.example.simpledatingservice.controller;

import com.example.simpledatingservice.entities.*;
import com.example.simpledatingservice.service.AnsweredQuestionService;
import com.example.simpledatingservice.service.TagService;
import com.example.simpledatingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
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

    @GetMapping("/getUser")
    public User getUserFromId(@AuthenticationPrincipal UsersLoginPrincipal principal) {
        return principal.getUserslogin().getUser();
    }

    @GetMapping("/getAnsweredQuestions")
    public List<AnsweredQuestion> getAnsweredQuestions(){
        List<AnsweredQuestion> answeredQ = answeredQuestionService.getAnsweredQuestions();
        System.out.println(answeredQ);
        return answeredQ;
    }

    @GetMapping("/getUnanswered/{forId}")
    public Question showUnasnweredQuestion(){
        return answeredQuestionService.getUnansweredQuestions();
    }






}
