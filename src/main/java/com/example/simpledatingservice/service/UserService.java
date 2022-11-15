package com.example.simpledatingservice.service;

import com.example.simpledatingservice.entities.User;
import com.example.simpledatingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUser(){
        Long temp = new Long(0);
        return userRepository.findById(temp).get();
    }
}
