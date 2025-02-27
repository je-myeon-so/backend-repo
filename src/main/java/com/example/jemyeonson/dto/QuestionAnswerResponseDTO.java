package com.example.jemyeonson.dto;

import lombok.Data;

@Data
public class QuestionAnswerResponseDTO {
    private boolean success;
    private Integer answerId;
    private Integer questionId;
}