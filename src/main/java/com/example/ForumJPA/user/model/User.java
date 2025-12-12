package com.example.ForumJPA.user.model;

import com.example.ForumJPA.topic.model.Topic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "regTime")
    private LocalDateTime regTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Topic> topics;

    public User() {
    }

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }
}
