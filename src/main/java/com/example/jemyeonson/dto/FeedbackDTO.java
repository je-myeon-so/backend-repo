package com.example.jemyeonson.dto;

import lombok.Data;

@Data
public class FeedbackDTO {
    private String errorText;
    private String errorType;
    private String feedback;
    private String suggestion;
}