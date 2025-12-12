package com.example.ForumJPA.topic.model.exception;

import com.example.ForumJPA.topic.model.response.TopicErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TopicExceptionHandler {

    @ExceptionHandler(TopicNotFoundedException.class)
    public ResponseEntity<TopicErrorResponse> topicErrorResponseResponseEntity(TopicNotFoundedException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TopicErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(TopicUpdateParamException.class)
    public ResponseEntity<TopicErrorResponse> topicUpdateError(TopicUpdateParamException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TopicErrorResponse(ex.getMessage()));
    }
}
