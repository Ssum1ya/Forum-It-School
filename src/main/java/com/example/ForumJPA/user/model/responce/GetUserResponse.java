package com.example.ForumJPA.user.model.responce;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GetUserResponse {
    private Long id;
    private String name;
    private String login;
    private LocalDateTime regTime;
    private List<Long> topics;

    public GetUserResponse(Long id, String name, String login, LocalDateTime regTime, List<Long> topics) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.regTime = regTime;
        this.topics = topics;
    }
}
