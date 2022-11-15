package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.AnsweredQuestion;
import org.springframework.data.repository.CrudRepository;

public interface AnsweredQuestionsRepository extends CrudRepository<AnsweredQuestion, Long> {
}
