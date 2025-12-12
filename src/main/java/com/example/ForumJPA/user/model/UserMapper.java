package com.example.ForumJPA.user.model;


import com.example.ForumJPA.user.model.request.AddUserRequest;
import com.example.ForumJPA.user.model.responce.AddUserResponse;
import com.example.ForumJPA.user.model.responce.GetUserResponse;

import java.util.List;

public class UserMapper {
    public static User addRequestToUser(AddUserRequest request) {
        User user = new User(request.getLogin(), request.getName());
        return user;
    }

    public static AddUserResponse userToAddResponse(User user) {
        AddUserResponse addUserResponse = new AddUserResponse(user.getId(), user.getName(), user.getLogin(), user.getRegTime());
        return addUserResponse;
    }

    public static GetUserResponse userToGetUserResponse(User user, List<Long> topics) {
        GetUserResponse getUserResponse = new GetUserResponse(user.getId(),
                user.getName(), user.getLogin(), user.getRegTime(), topics
        );
        return getUserResponse;
    }
}
