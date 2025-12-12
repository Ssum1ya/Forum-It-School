package com.example.ForumJPA.user.model.responce;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddUserResponse {
    private Long id;
    private String name;
    private String login;
    private LocalDateTime regTime;

    public AddUserResponse(Long id, String name, String login, LocalDateTime regTime) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.regTime = regTime;
    }
}
