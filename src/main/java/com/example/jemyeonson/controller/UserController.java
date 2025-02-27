package com.example.jemyeonson.controller;

import com.example.jemyeonson.dto.UserDto;
import com.example.jemyeonson.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/")
    public ResponseEntity<UserDto> getUser(){

    }



}
