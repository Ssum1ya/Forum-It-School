package com.example.ForumJPA.topic.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GetTopicResponse {
    private Long id;
    private Long authorId;
    private LocalDateTime creationTime;
    private String title;
    private String text;
    private List<Long> commentsId;

    public GetTopicResponse(Long id, Long authorId, LocalDateTime creationTime, String title, String text, List<Long> commentsId) {
        this.id = id;
        this.authorId = authorId;
        this.creationTime = creationTime;
        this.title = title;
        this.text = text;
        this.commentsId = commentsId;
    }
}
