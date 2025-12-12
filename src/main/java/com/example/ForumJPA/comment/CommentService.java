package com.example.ForumJPA.comment;

import com.example.ForumJPA.comment.model.Comment;
import com.example.ForumJPA.comment.model.CommentMapper;
import com.example.ForumJPA.comment.model.exception.CommentNotFoundException;
import com.example.ForumJPA.comment.model.exception.UpdateParamsNotFound;
import com.example.ForumJPA.comment.model.request.AddCommentRequest;
import com.example.ForumJPA.comment.model.response.AddCommentResponse;
import com.example.ForumJPA.topic.TopicRepository;
import com.example.ForumJPA.topic.model.Topic;
import com.example.ForumJPA.topic.model.exception.TopicNotFoundedException;
import com.example.ForumJPA.user.UserRepository;
import com.example.ForumJPA.user.model.User;
import com.example.ForumJPA.user.model.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final CommentRepository commentRepository;

    public CommentService(UserRepository userRepository, TopicRepository topicRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.commentRepository = commentRepository;
    }

    public AddCommentResponse saveComment(AddCommentRequest request) {
        User user = userRepository.findById(request.getAuthorId()).orElseThrow(() -> new UserNotFoundException("user with id not found"));
        Topic topic = topicRepository.findById(request.getTopicId()).orElseThrow(() -> new TopicNotFoundedException("topic with id not founded"));
        Comment comment = new Comment(request.getText(), topic, user);
        comment.setCreationTime(LocalDateTime.now());
        commentRepository.save(comment);
        return CommentMapper.commentToAddResponse(comment);
    }

    public AddCommentResponse deleteComment(Long id) {
        Comment deleteComment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("comment with id not found"));
        commentRepository.deleteById(id);

        return CommentMapper.commentToAddResponse(deleteComment);
    }

    public AddCommentResponse updateComment(Long id, String text) {
        Comment updateComment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("comment with id not found"));

        if (text == null) {
            throw new UpdateParamsNotFound("need text param to update");
        }

        updateComment.setText(text);
        commentRepository.save(updateComment);

        return CommentMapper.commentToAddResponse(updateComment);
    }
}
