package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
