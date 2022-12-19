package com.example.simpledatingservice.controller;

import com.example.simpledatingservice.DTO.*;
import com.example.simpledatingservice.entities.*;
import com.example.simpledatingservice.repository.UserLoginRepository;
import com.example.simpledatingservice.service.*;
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

    @Autowired
    private QuestionService questionService;

    @GetMapping("/getTags")
    public List<Tag> getAllTags(){
       return  tagService.getTags();
    }

    @GetMapping("/user")
    public User getCurrentUser(@AuthenticationPrincipal UsersLoginPrincipal principal) {
        //org.hibernate.LazyInitializationException
        //the answered questions can't be initalized, get it from transactional method
        User user = userService.getUser(principal.getUserslogin().getId());
        return user;
    }

    @PostMapping("/user")
    public void updateUser(@AuthenticationPrincipal UsersLoginPrincipal principal, @RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO, principal.getUserslogin().getId());
    }

    @GetMapping("/user/{userId}")
    public User getUserFromId(@PathVariable("userId") long id) {
        User user = userService.getUser(id);
        return user;
    }

    //add ExclusionForThis
    @PostMapping("/user-credentials/new")
    public void createUser(@RequestBody UserCredentialDTO userCredentials){
        customUserDetailService.createNewUser(userCredentials);
    }

    @PostMapping("/user-credentials/update")
    public void updateCredentials(@RequestBody UserCredentialDTO userCredentials, @AuthenticationPrincipal UsersLoginPrincipal principal){
        customUserDetailService.updatePassword(userCredentials, principal.getUserslogin().getId());
    }

    //Get 5 random results that has this tag
    @GetMapping("/user/{userid}/tags")
    public List<Tag> getTags(@PathVariable(name = "userid") long id){
        return userService.getUser(id).getTags();
    }

    @GetMapping("/user/tags")
    public TagsDTO getTags(@AuthenticationPrincipal UsersLoginPrincipal principal){
        TagsDTO dto = new TagsDTO();
        dto.setSelectedTags(userService.getUser(principal.getUserslogin().getId()).getTags());
        dto.setNonSelectedTags(tagService.getNonSelectedTags());
        return dto;
    }

    @PostMapping("/user/tags")
    public void updateTags(@AuthenticationPrincipal UsersLoginPrincipal principal, @RequestBody TagsDTO tagsDTO){
        long loggedInId = principal.getUserslogin().getId();
        userService.updateUsersTags(loggedInId, tagsDTO.getSelectedTags());
    }

    @GetMapping("/user/questions")
    public QuestionsDTO getQuestions(@AuthenticationPrincipal UsersLoginPrincipal principal) {
        QuestionsDTO questionsDTO = new QuestionsDTO();
        Long id = principal.getUserslogin().getId();
        List<AnsweredQuestion> answered = answeredQuestionService.getAnsweredQuestions(id);
        List<Question> unanswered = answeredQuestionService.getUnansweredQuestions(id);
        questionsDTO.setAnsweredQuestions(answered);
        questionsDTO.setNonAnsweredQuestions(unanswered);
        return questionsDTO;
    }

    @GetMapping("/user/questions/{question_id}")
    public QuestionDTO getQuestion(@PathVariable("question_id") long questionId, @AuthenticationPrincipal UsersLoginPrincipal principal){
        long userId = principal.getUserslogin().getId();
        Answer answer = answeredQuestionService.getUsersAnswer(userId, questionId);
        Question question = questionService.getQuestionById(questionId);
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setContent(question.getContent());
        questionDTO.setPossibleAnswers(question.getPossibleAnswers());
        questionDTO.setChosenAnswer(answer);
        return questionDTO;
    }

    @PostMapping("/user/questions/{question_id}")
    public void answerQuestion(@PathVariable("question_id") long questionId, @RequestBody AnswerQuestionDTO answeredQuestion, @AuthenticationPrincipal UsersLoginPrincipal principal) {
        answeredQuestion.setQuestionId(questionId);
        answeredQuestionService.answerQuestion(answeredQuestion, principal.getUserslogin().getId());
    }

    @GetMapping("/user/search/{tagId}")
    public List<MatchDTO> searchByTag(@PathVariable("tagId") long tagId) {
        return null;
        //todo
    }

    //return a page including
    @GetMapping("/getUser/{userId}")
    public MatchDTO getInformationAboutUser(@PathVariable("userId") long userId){
        return null;
        //todo
    }

}
