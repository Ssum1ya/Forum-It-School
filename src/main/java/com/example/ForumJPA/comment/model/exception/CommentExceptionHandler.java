package com.example.ForumJPA.comment.model.exception;

import com.example.ForumJPA.comment.model.response.CommentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommentExceptionHandler {

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<CommentErrorResponse> commentNotFoundException(CommentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CommentErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(UpdateParamsNotFound.class)
    public ResponseEntity<CommentErrorResponse> commentUpdateException(UpdateParamsNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CommentErrorResponse(ex.getMessage()));
    }
}
