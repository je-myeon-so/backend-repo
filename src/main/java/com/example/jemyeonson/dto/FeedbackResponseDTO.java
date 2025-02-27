package com.example.jemyeonson.dto;

import lombok.Data;

@Data
public class FeedbackResponseDTO {
    private boolean success;
    private Integer feedbackId;
    private Integer answerId;
    private Integer questionId;
}