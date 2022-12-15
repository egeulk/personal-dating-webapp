package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.AnsweredQuestion;
import com.example.simpledatingservice.entities.Question;
import com.example.simpledatingservice.entities.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnsweredQuestionsRepository extends CrudRepository<AnsweredQuestion, Long> {
    @Query(value = "SELECT q FROM Question q, AnsweredQuestion aq WHERE q.id NOT in (SELECT aq.question.id FROM AnsweredQuestion aq WHERE aq.user.id=:userId) ")
    List<Question> findNonAnsweredQuestions(@Param("userId") Long userId);

    List<AnsweredQuestion> findByUser_Id(Long id);
    long deleteByQuestion_IdAndUser_Id(long questionId, Long userId);




}
