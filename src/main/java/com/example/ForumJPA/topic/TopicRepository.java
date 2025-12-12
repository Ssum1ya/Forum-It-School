package com.example.ForumJPA.topic;

import com.example.ForumJPA.topic.model.Topic;
import com.example.ForumJPA.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t.id FROM Topic t where t.author = :author")
    List<Long> findIdTopicsByAuthor(@Param("author") User author);
}
