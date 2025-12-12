package com.example.ForumJPA.user.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String login;
    private String name;

    public AddUserRequest(String name, String login) {
        this.name = name;
        this.login = login;
    }
}
