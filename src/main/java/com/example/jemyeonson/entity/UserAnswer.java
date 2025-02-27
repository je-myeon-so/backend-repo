package com.example.jemyeonson.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "UserAnswer")
@Data
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerid")
    private Integer answerId;

    @Column(name = "questionid")
    private Integer questionId;

    @Column(name = "username", length = 36)
    private String username;

    @Column(name = "answertext", columnDefinition = "TEXT")
    private String answerText;

    // 외래 키 관계 설정
    @ManyToOne
    @JoinColumn(name = "questionid", insertable = false, updatable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;

// 생성자, getter, setter 등은 Lombok의 @Data가 자동 생성

}