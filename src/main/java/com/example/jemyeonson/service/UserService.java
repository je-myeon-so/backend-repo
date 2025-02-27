package com.example.jemyeonson.service;

import com.example.jemyeonson.dto.UserDto;
import com.example.jemyeonson.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto){

    }
}
