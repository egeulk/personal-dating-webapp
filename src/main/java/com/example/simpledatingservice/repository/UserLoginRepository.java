package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.DTO.UserCredentialDTO;
import com.example.simpledatingservice.entities.UsersLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface UserLoginRepository extends JpaRepository<UsersLogin, Long> {



    public UsersLogin findByEmail(String email);

}
