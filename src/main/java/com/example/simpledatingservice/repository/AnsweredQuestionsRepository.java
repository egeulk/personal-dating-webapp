package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnsweredQuestionsRepository extends CrudRepository<AnsweredQuestion, Long> {
    @Query(" SELECT q FROM Question q, AnsweredQuestion aw WHERE aw.user.id=0 AND q.id = aw.question.id")
    Question findNonAnsweredQuestions();
}
