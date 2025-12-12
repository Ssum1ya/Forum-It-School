package com.example.ForumJPA.topic.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicErrorResponse {
    private String message;

    public TopicErrorResponse(String message) {
        this.message = message;
    }
}
