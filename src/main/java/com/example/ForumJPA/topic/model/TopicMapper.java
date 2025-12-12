package com.example.ForumJPA.topic.model;

import com.example.ForumJPA.topic.model.request.AddTopicRequest;
import com.example.ForumJPA.topic.model.response.AddTopicResponse;
import com.example.ForumJPA.topic.model.response.DeleteTopicResponse;
import com.example.ForumJPA.topic.model.response.GetTopicResponse;

import java.util.List;

public class TopicMapper {

    public static Topic addTopicRequestToTopic(AddTopicRequest request) {
        Topic topic = new Topic(request.getText(), request.getTitle());
        return topic;
    }

    public static AddTopicResponse TopicToAddTopicResponse(Topic topic) {
        AddTopicResponse addTopicResponse = new AddTopicResponse(topic.getId(),
                topic.getText(),
                topic.getTitle(),
                topic.getCreationTime(),
                topic.getAuthor().getId());
        return addTopicResponse;
    }

    public static DeleteTopicResponse topicToDeleteResponse(Topic topic) {
        DeleteTopicResponse deleteTopicResponse = new DeleteTopicResponse(
                topic.getId(), topic.getAuthor().getId(), topic.getCreationTime(), topic.getTitle(), topic.getText()
        );

        return deleteTopicResponse;
    }

    public static GetTopicResponse topicToGetResponse(Topic topic, List<Long> comments) {
        GetTopicResponse getTopicResponse = new GetTopicResponse(
                topic.getId(),
                topic.getAuthor().getId(),
                topic.getCreationTime(),
                topic.getTitle(),
                topic.getText(),
                comments
        );
        return getTopicResponse;
    }
}
