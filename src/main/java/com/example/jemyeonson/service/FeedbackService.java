package com.example.jemyeonson.service;

import com.example.jemyeonson.dto.FeedbackDTO;
import com.example.jemyeonson.dto.FeedbackResponseDTO;
import com.example.jemyeonson.entity.Feedback;
import com.example.jemyeonson.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Transactional
    public FeedbackResponseDTO saveFeedback(String username, Integer answerId, Integer questionId, FeedbackDTO feedbackDTO) {
        // 피드백 저장
        Feedback feedback = new Feedback();
        feedback.setUsername(username);
        feedback.setAnswerId(answerId);
        feedback.setQuestionId(questionId);
        feedback.setErrorText(feedbackDTO.getErrorText());
        feedback.setErrorType(feedbackDTO.getErrorType());
        feedback.setFeedback(feedbackDTO.getFeedback());
        feedback.setSuggestion(feedbackDTO.getSuggestion());

        Feedback savedFeedback = feedbackRepository.save(feedback);

        // 응답 DTO 생성
        FeedbackResponseDTO responseDTO = new FeedbackResponseDTO();
        responseDTO.setSuccess(true);
        responseDTO.setFeedbackId(savedFeedback.getFeedbackId());
        responseDTO.setAnswerId(savedFeedback.getAnswerId());
        responseDTO.setQuestionId(savedFeedback.getQuestionId());

        return responseDTO;
    }
}