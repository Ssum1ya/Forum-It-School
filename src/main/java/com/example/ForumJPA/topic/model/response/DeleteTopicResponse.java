package com.example.ForumJPA.topic.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeleteTopicResponse {
    private Long id;
    private Long authorId;
    private LocalDateTime creationTime;
    private String title;
    private String text;

    public DeleteTopicResponse(Long id, Long authorId, LocalDateTime creationTime, String title, String text) {
        this.id = id;
        this.authorId = authorId;
        this.creationTime = creationTime;
        this.title = title;
        this.text = text;
    }
}
