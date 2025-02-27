package com.example.jemyeonson.controller;

import com.example.jemyeonson.dto.FeedbackDTO;
import com.example.jemyeonson.dto.FeedbackResponseDTO;
import com.example.jemyeonson.repository.FeedbackRepository;
import com.example.jemyeonson.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, FeedbackRepository feedbackRepository) {
        this.feedbackService = feedbackService;
        this.feedbackRepository = feedbackRepository;
    }

    @PostMapping("/{answerId}/feedback")
    public ResponseEntity<FeedbackResponseDTO> saveFeedback(
            @PathVariable("answerId") Integer answerId,
            @RequestParam Integer questionId,
            @RequestParam(required = false) String username,
            @RequestBody FeedbackDTO feedbackDTO) {

        // 현재 로그인한 사용자 이름을 가져오는 로직
        if (username == null || username.isEmpty()) {
            username = "useruser"; // 기본값 또는 현재 로그인한 사용자로 대체
        }

        FeedbackResponseDTO responseDTO = feedbackService.saveFeedback(username, answerId, questionId, feedbackDTO);

        if (responseDTO.isSuccess()) {
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED); // 201 Created
        } else {
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST); // 400 Bad Request
        }
    }

    @GetMapping("/{answerId}/feedback")
    public ResponseEntity<?> getFeedback(
            @PathVariable("answerId") Integer answerId,
            @RequestParam(required = false) String username) {

        // 현재 로그인한 사용자 이름을 가져오는 로직
        if (username == null || username.isEmpty()) {
            username = "useruser"; // 기본값 또는 현재 로그인한 사용자로 대체
        }

        // 이 부분은 실제 서비스에서 피드백 조회 로직을 구현하면 됩니다.
        // 지금은 뼈대만 구현한 상태입니다.
        return new ResponseEntity<>("피드백 조회 기능은 추후 구현 예정", HttpStatus.OK);
    }
}