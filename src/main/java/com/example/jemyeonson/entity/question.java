package com.example.jemyeonson.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Question")
@Data
public class question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionid")
    private Integer questionId;

    @Column(name = "username", length = 36)
    private String username;

    @Column(name = "questiontext")
    private String questionText;

    @Column(name = "questionnum")
    private Integer questionNum;

    @Column(name = "questiontype", length = 36)
    private String questionType;

    // 외래 키 관계 설정
    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;

    // 생성자, getter, setter 등은 Lombok의 @Data가 자동 생성
}