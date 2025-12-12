package com.example.ForumJPA.comment.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddCommentResponse {
    private Long id;
    private Long authorId;
    private Long topicId;
    private String text;
    private LocalDateTime creationTime;

    public AddCommentResponse(Long id, Long authorId, Long topicId, String text, LocalDateTime creationTime) {
        this.id = id;
        this.authorId = authorId;
        this.topicId = topicId;
        this.text = text;
        this.creationTime = creationTime;
    }
}
