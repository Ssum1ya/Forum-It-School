package com.example.ForumJPA.user.model.responce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserErrorResponse {
    private String message;

    public UserErrorResponse(String message) {
        this.message = message;
    }
}
