package com.example.ForumJPA.comment.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCommentRequest {
    private Long authorId;
    private Long topicId;
    private String text;

    public AddCommentRequest(Long authorId, Long topicId, String text) {
        this.authorId = authorId;
        this.topicId = topicId;
        this.text = text;
    }
}
