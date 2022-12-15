package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
