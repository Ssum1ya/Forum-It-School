package com.example.ForumJPA.topic;

import com.example.ForumJPA.comment.CommentRepository;
import com.example.ForumJPA.topic.model.Topic;
import com.example.ForumJPA.topic.model.TopicMapper;
import com.example.ForumJPA.topic.model.exception.TopicNotFoundedException;
import com.example.ForumJPA.topic.model.exception.TopicUpdateParamException;
import com.example.ForumJPA.topic.model.request.AddTopicRequest;
import com.example.ForumJPA.topic.model.response.AddTopicResponse;
import com.example.ForumJPA.topic.model.response.DeleteTopicResponse;
import com.example.ForumJPA.topic.model.response.GetTopicResponse;
import com.example.ForumJPA.user.UserRepository;
import com.example.ForumJPA.user.model.User;
import com.example.ForumJPA.user.model.exception.UserNotFoundException;
import com.example.ForumJPA.user.model.responce.AddUserResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicService {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final CommentRepository commentRepository;

    public TopicService(UserRepository userRepository, TopicRepository topicRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.commentRepository = commentRepository;
    }

    public AddTopicResponse saveTopic(AddTopicRequest request) {
        Topic saveTopic = TopicMapper.addTopicRequestToTopic(request);
        User user = userRepository.findById(request.getAuthorId()).orElseThrow(() -> new UserNotFoundException("author not founded "));

        saveTopic.setAuthor(user);
        saveTopic.setCreationTime(LocalDateTime.now());
        Topic savedTopic = topicRepository.save(saveTopic);

        return TopicMapper.TopicToAddTopicResponse(savedTopic);
    }

    public DeleteTopicResponse deleteTopic(Long id) {
        Topic delTopic = topicRepository.findById(id).orElseThrow(() -> new TopicNotFoundedException("topic with id not founded"));
        topicRepository.deleteById(id);
        return TopicMapper.topicToDeleteResponse(delTopic);
    }

    public AddTopicResponse updateTopic(Long id, String text, String title) {
        Topic updateTopic = topicRepository.findById(id).orElseThrow(() -> new TopicNotFoundedException("topic with id not founded"));
        if (text == null && title == null) {
            throw new TopicUpdateParamException("need at least 1 param (title or text) for update");
        }
        if (text != null) {
            updateTopic.setText(text);
        }
        if (title != null) {
            updateTopic.setTitle(title);
        }

        topicRepository.save(updateTopic);

        return TopicMapper.TopicToAddTopicResponse(updateTopic);
    }

    public GetTopicResponse getTopic(Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new TopicNotFoundedException("topic with id not founded"));

        List<Long> comments = commentRepository.findByTopic(topic);

        return TopicMapper.topicToGetResponse(topic, comments);
    }
}
