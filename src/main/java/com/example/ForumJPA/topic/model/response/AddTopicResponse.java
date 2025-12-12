package com.example.ForumJPA.topic.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddTopicResponse {
    private Long id;
    private String text;
    private String title;
    private LocalDateTime creationTime;
    private Long authorId;

    public AddTopicResponse(Long id, String text, String title, LocalDateTime creationTime, Long authorId) {
        this.id = id;
        this.text = text;
        this.title = title;
        this.creationTime = creationTime;
        this.authorId = authorId;
    }
}
