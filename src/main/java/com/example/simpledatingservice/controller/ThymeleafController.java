package com.example.simpledatingservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/landing")
    public String homePage(){
        return "landing";
    }

    @GetMapping("/profile")
    public String profilePage(){
        return "myprofile";
    }

}
