package com.example.ForumJPA.user;

import com.example.ForumJPA.user.model.request.AddUserRequest;
import com.example.ForumJPA.user.model.responce.AddUserResponse;
import com.example.ForumJPA.user.model.responce.GetUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<AddUserResponse> addUser(@RequestBody AddUserRequest request) {
        AddUserResponse response = userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddUserResponse> updateUser(@PathVariable("id") Long id, @RequestParam(required = false) String name) {
        AddUserResponse addUserResponse = userService.updateUser(id, name);
        return ResponseEntity.status(HttpStatus.OK).body(addUserResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable("id") Long id) {
        GetUserResponse response = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
