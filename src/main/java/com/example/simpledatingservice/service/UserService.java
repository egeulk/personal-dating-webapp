package com.example.simpledatingservice.service;

import com.example.simpledatingservice.DTO.UserDTO;
import com.example.simpledatingservice.entities.Tag;
import com.example.simpledatingservice.entities.User;
import com.example.simpledatingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    @Transactional
    public void updateUsersTags(long id, List<Tag> tags) {
        User user = userRepository.findById(id).get();
        user.setTags(tags);
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO, long id) {
        User user = userRepository.findById(id).get();
        user = updateUserFromDTO(userDTO, user);
        userRepository.save(user);
    }

    private User updateUserFromDTO(UserDTO userDTO, User user){
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setGenderAsString(userDTO.getGender());
        user.setGenderAsString(userDTO.getPronoun());
        return user;
    }
}
