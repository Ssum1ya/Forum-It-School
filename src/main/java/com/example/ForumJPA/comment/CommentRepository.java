package com.example.ForumJPA.comment;

import com.example.ForumJPA.comment.model.Comment;
import com.example.ForumJPA.topic.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c.id FROM Comment c where c.topic = :topic")
    List<Long> findByTopic(Topic topic);
}
