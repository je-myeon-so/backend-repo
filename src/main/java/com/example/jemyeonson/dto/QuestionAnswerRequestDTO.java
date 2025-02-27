package com.example.jemyeonson.dto;

import lombok.Data;

@Data
public class QuestionAnswerRequestDTO {
    private QuestionDTO question;
    private AnswerDTO answer;

    @Data
    public static class QuestionDTO {
        private String questionText;
        private String questionType;
    }

    @Data
    public static class AnswerDTO {
        private String answerText;
    }

}