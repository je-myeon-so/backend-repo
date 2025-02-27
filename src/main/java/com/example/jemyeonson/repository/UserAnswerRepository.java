package com.example.jemyeonson.repository;

import com.example.jemyeonson.entity.UserAnswer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into UserAnswer (questionId, username, answerText) values (:questionId, :username, :answerText)")
    void insertUserAnswer(@Param("questionId") Integer questionId,
                          @Param("username") String username,
                          @Param("answerText") String answerText);
}