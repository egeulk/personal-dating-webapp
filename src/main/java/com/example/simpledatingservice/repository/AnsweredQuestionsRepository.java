package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AnsweredQuestionsRepository extends CrudRepository<AnsweredQuestion, Long> {
    @Query(value = "SELECT q FROM Question q, AnsweredQuestion aq WHERE q.id NOT in (SELECT aq.question.id FROM AnsweredQuestion aq WHERE aq.user.id=:userId) ")
    List<Question> findNonAnsweredQuestions(@Param("userId") Long userId);

    List<AnsweredQuestion> findByUser_Id(Long id);

    AnsweredQuestion findByQuestion_IdAndUser_Id(long questionId, Long answerId);



    long deleteByQuestion_IdAndUser_Id(long questionId, Long userId);

    @Transactional
    @Modifying
    @Query("update AnsweredQuestion a set a.answer = ?1, a.importance = ?2 where a.user.id = ?3 and a.question.id = ?4")
    int updateAnswerAndImportanceByUserAndQuestion(Answer answer, short importance, long user, long question);








}
