package com.example.ForumJPA.topic.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTopicRequest {
    private Long authorId;
    private String title;
    private String text;

    public AddTopicRequest(Long authorId, String title, String text) {
        this.authorId = authorId;
        this.title = title;
        this.text = text;
    }
}
