package com.example.jemyeonson.repository;

import com.example.jemyeonson.entity.useranswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<useranswer, Integer> {
// 기본 CRUD 작업은 JpaRepository가 제공
}