package com.example.jemyeonson.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="User")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
