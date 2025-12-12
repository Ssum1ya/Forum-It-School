package com.example.ForumJPA.topic.model.exception;

public class TopicNotFoundedException extends RuntimeException {
    public TopicNotFoundedException(String message) {
        super(message);
    }
}
