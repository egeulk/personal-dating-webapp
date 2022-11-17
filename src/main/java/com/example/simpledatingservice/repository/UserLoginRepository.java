package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.UsersLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserLoginRepository extends JpaRepository<UsersLogin, Long> {

    public UsersLogin findByEmail(String email);
}
