package com.example.simpledatingservice.controller;

import com.example.simpledatingservice.DTO.MatchDTO;
import com.example.simpledatingservice.DTO.UserCredentialDTO;
import com.example.simpledatingservice.DTO.UserDTO;
import com.example.simpledatingservice.entities.*;
import com.example.simpledatingservice.repository.UserLoginRepository;
import com.example.simpledatingservice.service.AnsweredQuestionService;
import com.example.simpledatingservice.service.CustomUserDetailService;
import com.example.simpledatingservice.service.TagService;
import com.example.simpledatingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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
    private CustomUserDetailService customUserDetailService;

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

    //add ExclusionForThis
    @PostMapping("/createNewUser")
    public void createAUser(@RequestBody UserCredentialDTO userCredentials){
        customUserDetailService.createNewUser(userCredentials);
        userService.createNewUser();
    }

    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody UserCredentialDTO userCredentials){
        customUserDetailService.createNewUser(userCredentials);
        userService.createNewUser();
    }

    @GetMapping("/getByTag/{tagId}")
    public List<UserDTO> getCandidatesFromTag(@PathVariable("tagId") long tagId){
        return null;
    }

    @GetMapping("/getUser/{userId}")
    public MatchDTO getInhformationAboutUser(@PathVariable("userId") long userId){
        return null;
    }


/*
Not working yet

    @GetMapping("/getUnanswered/{forId}")
    public Question showUnasnweredQuestion(){
        return answeredQuestionService.getUnansweredQuestions();
    }

 */






}
