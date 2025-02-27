package com.example.jemyeonson.repository;

import com.example.jemyeonson.entity.Question;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into Question (username, questionText, questionNum, questionType) values (:username, :questionText, :questionNum, :questionType)")
    void insertQuestion(@Param("username") String username,
                        @Param("questionText") String questionText,
                        @Param("questionNum") Integer questionNum,
                        @Param("questionType") String questionType);
}