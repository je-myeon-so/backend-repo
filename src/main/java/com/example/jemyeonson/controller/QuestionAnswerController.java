package com.example.jemyeonson.controller;

import com.example.jemyeonson.dto.QuestionAnswerRequestDTO;
import com.example.jemyeonson.dto.QuestionAnswerResponseDTO;
import com.example.jemyeonson.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// 질문+답변 관련 api
@RequestMapping("/questions")
public class QuestionAnswerController {

    private final QuestionAnswerService questionAnswerService;

    @Autowired
    public QuestionAnswerController(QuestionAnswerService questionAnswerService) {
        this.questionAnswerService = questionAnswerService;
    }

    @PostMapping("/{questionId}/answers")
    public ResponseEntity<QuestionAnswerResponseDTO> saveQuestionAndAnswer(
            @PathVariable("questionId") Integer questionId,
            @RequestBody QuestionAnswerRequestDTO requestDTO,
            @RequestParam(required = false) String username) {

        // 현재 로그인한 사용자 이름을 가져오는 로직 (실제로는 Spring Security에서 가져올 수 있음)
        if (username == null || username.isEmpty()) {
            username = "useruser"; // 기본값 또는 현재 로그인한 사용자로 대체
        }

        QuestionAnswerResponseDTO responseDTO = questionAnswerService.saveQuestionAndAnswer(username, requestDTO);

        if (responseDTO.isSuccess()) {
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED); // 201 Created
        } else {
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST); // 400 Bad Request
        }
    }

}