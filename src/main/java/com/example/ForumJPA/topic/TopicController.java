package com.example.ForumJPA.topic;

import com.example.ForumJPA.topic.model.Topic;
import com.example.ForumJPA.topic.model.request.AddTopicRequest;
import com.example.ForumJPA.topic.model.response.AddTopicResponse;
import com.example.ForumJPA.topic.model.response.DeleteTopicResponse;
import com.example.ForumJPA.topic.model.response.GetTopicResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<AddTopicResponse> addTopic(@RequestBody AddTopicRequest request) {
        AddTopicResponse response = topicService.saveTopic(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTopicResponse> deleteTopic(@PathVariable("id") Long id) {
        DeleteTopicResponse delTopic = topicService.deleteTopic(id);
        return ResponseEntity.status(HttpStatus.OK).body(delTopic);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<AddTopicResponse> updateTopic(@PathVariable Long id,
                                                         @RequestParam(value = "title", required = false) String title,
                                                         @RequestParam(value = "text", required = false) String text) {
        AddTopicResponse response = topicService.updateTopic(id, text, title);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetTopicResponse> getTopic(@PathVariable Long id) {
        GetTopicResponse getTopicResponse = topicService.getTopic(id);

        return ResponseEntity.status(HttpStatus.OK).body(getTopicResponse);
    }
}
