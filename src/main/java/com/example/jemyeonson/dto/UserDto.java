package com.example.jemyeonson.dto;

import lombok.Getter;

@Getter
public class UserDto {

    private String username;
    private String password;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
