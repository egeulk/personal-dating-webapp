package com.example.simpledatingservice.service;

import com.example.simpledatingservice.DTO.UserDTO;
import com.example.simpledatingservice.entities.User;
import com.example.simpledatingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Transactional
    public User getUser(long userId) {
        return userRepository.findById(userId).get();
     }
    @Transactional
    public void createNewUser() {
        User user = new User();
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO, long id) {
        User user = dtoToObject(userDTO);
        user.setId(id);
        userRepository.save(user);
    }

    public User dtoToObject(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setGenderAsString(userDTO.getGender());
        user.setGenderAsString(userDTO.getPronoun());
        return user;
    }
}
