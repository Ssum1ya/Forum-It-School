package com.example.ForumJPA.topic.model;

import com.example.ForumJPA.comment.model.Comment;
import com.example.ForumJPA.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)

    private User author;

    @Column(name = "creationTime")
    private LocalDateTime creationTime;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", cascade = CascadeType.REMOVE)
    private List<Comment> comments;


    public Topic(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Topic() {
    }
}
