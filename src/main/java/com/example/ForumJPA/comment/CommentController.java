package com.example.ForumJPA.comment;

import com.example.ForumJPA.comment.model.request.AddCommentRequest;
import com.example.ForumJPA.comment.model.response.AddCommentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<AddCommentResponse> addComment(@RequestBody AddCommentRequest request) {
        AddCommentResponse response = commentService.saveComment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddCommentResponse> deleteComment(@PathVariable Long id) {
        AddCommentResponse response = commentService.deleteComment(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddCommentResponse> updateComment(@PathVariable Long id,
                                                            @RequestParam(value = "text", required = false) String text) {
        AddCommentResponse response = commentService.updateComment(id, text);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
