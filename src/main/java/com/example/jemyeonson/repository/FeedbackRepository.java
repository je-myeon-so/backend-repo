package com.example.jemyeonson.repository;

import com.example.jemyeonson.entity.Feedback;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into Feedback (answerId, questionId, username, errorText, errorType, feedback, suggestion) " +
            "values (:answerId, :questionId, :username, :errorText, :errorType, :feedback, :suggestion)")
    void insertFeedback(@Param("answerId") Integer answerId,
                        @Param("questionId") Integer questionId,
                        @Param("username") String username,
                        @Param("errorText") String errorText,
                        @Param("errorType") String errorType,
                        @Param("feedback") String feedback,
                        @Param("suggestion") String suggestion);
}