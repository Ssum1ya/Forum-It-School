package com.example.ForumJPA.comment.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentErrorResponse {
    private String message;

    public CommentErrorResponse(String message) {
        this.message = message;
    }
}
