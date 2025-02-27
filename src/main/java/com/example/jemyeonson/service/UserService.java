package com.example.jemyeonson.service;

import com.example.jemyeonson.dto.UserDto;
import com.example.jemyeonson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<UserDto> createUser(UserDto userDto) {
        try {
            userRepository.insertUser(userDto.getUsername(), userDto.getPassword());
            return Optional.of(userDto);
        } catch (DataIntegrityViolationException e) {
            return Optional.empty();
        }
    }

}
