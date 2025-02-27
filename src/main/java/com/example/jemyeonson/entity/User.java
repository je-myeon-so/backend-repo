package com.example.jemyeonson.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
