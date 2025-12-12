package com.example.ForumJPA.user.model.exception;

import com.example.ForumJPA.user.model.responce.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<UserErrorResponse> userAlreadyExistException(UserAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserErrorResponse> userNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(UserUpdateParamException.class)
    public ResponseEntity<UserErrorResponse> userUpdateException(UserUpdateParamException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserErrorResponse(ex.getMessage()));
    }
}
