// QuestionAnswerService.java
package com.example.jemyeonson.service;

import com.example.jemyeonson.dto.QuestionAnswerRequestDTO;
import com.example.jemyeonson.dto.QuestionAnswerResponseDTO;
import com.example.jemyeonson.entity.question;
import com.example.jemyeonson.entity.useranswer;
import com.example.jemyeonson.repository.QuestionRepository;
import com.example.jemyeonson.repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionAnswerService {

    private final QuestionRepository questionRepository;
    private final UserAnswerRepository userAnswerRepository;

    @Autowired
    public QuestionAnswerService(QuestionRepository questionRepository, UserAnswerRepository userAnswerRepository) {
        this.questionRepository = questionRepository;
        this.userAnswerRepository = userAnswerRepository;
    }

    @Transactional
    public QuestionAnswerResponseDTO saveQuestionAndAnswer(String username, QuestionAnswerRequestDTO requestDTO) {
        // 질문 저장
        question question = new question();
        question.setUsername(username);
        question.setQuestionText(requestDTO.getQuestion().getQuestionText());
        question.setQuestionType(requestDTO.getQuestion().getQuestionType());
        question.setQuestionNum(1); // 기본값 설정, 필요에 따라 조정

        question savedQuestion = questionRepository.save(question);

        // 답변 저장
        useranswer userAnswer = new useranswer();
        userAnswer.setQuestionId(savedQuestion.getQuestionId());
        userAnswer.setUsername(username);
        userAnswer.setAnswerText(requestDTO.getAnswer().getAnswerText());

        useranswer savedAnswer = userAnswerRepository.save(userAnswer);

        // 응답 DTO 생성
        QuestionAnswerResponseDTO responseDTO = new QuestionAnswerResponseDTO();
        responseDTO.setSuccess(true);
        responseDTO.setQuestionId(savedQuestion.getQuestionId());
        responseDTO.setAnswerId(savedAnswer.getAnswerId());

        return responseDTO;
    }

}