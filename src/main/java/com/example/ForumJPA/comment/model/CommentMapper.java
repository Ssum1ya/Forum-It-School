package com.example.ForumJPA.comment.model;

import com.example.ForumJPA.comment.model.response.AddCommentResponse;

public class CommentMapper {

    public static AddCommentResponse commentToAddResponse(Comment comment) {
        AddCommentResponse response = new AddCommentResponse(
                comment.getId(), comment.getAuthor().getId(), comment.getTopic().getId(), comment.getText(), comment.getCreationTime()
        );
        return response;
    }
}
