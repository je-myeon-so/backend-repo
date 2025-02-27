package com.example.jemyeonson.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @Column(name = "username", length = 36)
    private String username;

    @Column(name = "password", length = 36)
    private String password;

// 생성자, getter, setter 등은 Lombok의 @Data가 자동 생성

}