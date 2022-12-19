package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnsweredQuestionsRepository extends CrudRepository<AnsweredQuestion, Long> {
    @Query(value = "SELECT q FROM Question q, AnsweredQuestion aq JOIN aq.user u " +
            "WHERE q.id NOT IN   (SELECT q.id FROM q, aq JOIN aq.user u WHERE u.id = :userId)")
    List<Question> findNonAnsweredQuestions(@Param("userId") Long userId);

    @Query(value = "SELECT aq.answer FROM AnsweredQuestion aq WHERE aq.user.id = :userId AND aq.question.id=:questionId")
    Answer findAnswerByUserAndQuestionId(@Param("userId") Long userId, @Param("questionId") Long questionId);

    List<AnsweredQuestion> findByUser_Id(Long id);

    AnsweredQuestion findByQuestion_IdAndUser_Id(long questionId, Long answerId);

    long deleteByQuestion_IdAndUser_Id(long questionId, Long userId);

}
