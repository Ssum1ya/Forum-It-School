package com.example.ForumJPA.comment.model;

import com.example.ForumJPA.topic.model.Topic;
import com.example.ForumJPA.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @Column(name = "creationTime")
    private LocalDateTime creationTime;

    @Column(name = "text")
    private String text;

    public Comment() {
    }

    public Comment(String text, Topic topic, User author) {
        this.text = text;
        this.topic = topic;
        this.author = author;
    }
}
