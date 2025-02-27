package com.example.jemyeonson.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Feedback")
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedbackid")
    private Integer feedbackId;

    @Column(name = "answerid")
    private Integer answerId;

    @Column(name = "questionid")
    private Integer questionId;

    @Column(name = "username", length = 36)
    private String username;

    @Column(name = "errortext")
    private String errorText;

    @Column(name = "errortype", length = 36)
    private String errorType;

    @Column(name = "feedback", length = 36)
    private String feedback;

    @Column(name = "suggestion", columnDefinition = "TEXT")
    private String suggestion;

    // 외래 키 관계 설정
    @ManyToOne
    @JoinColumn(name = "answerid", referencedColumnName = "answerid", insertable = false, updatable = false)
    private UserAnswer userAnswer;

    @ManyToOne
    @JoinColumn(name = "questionid", referencedColumnName = "questionid", insertable = false, updatable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private User user;

    public Feedback() {
        // 기본 생성자
    }
}

