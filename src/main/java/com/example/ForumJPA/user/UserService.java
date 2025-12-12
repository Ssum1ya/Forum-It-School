package com.example.ForumJPA.user;

import com.example.ForumJPA.topic.TopicRepository;
import com.example.ForumJPA.user.model.User;
import com.example.ForumJPA.user.model.UserMapper;
import com.example.ForumJPA.user.model.exception.UserAlreadyExistException;
import com.example.ForumJPA.user.model.exception.UserNotFoundException;
import com.example.ForumJPA.user.model.exception.UserUpdateParamException;
import com.example.ForumJPA.user.model.request.AddUserRequest;
import com.example.ForumJPA.user.model.responce.AddUserResponse;
import com.example.ForumJPA.user.model.responce.GetUserResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;

    public UserService(UserRepository userRepository, TopicRepository topicRepository) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
    }

    public AddUserResponse saveUser(AddUserRequest request) throws UserAlreadyExistException {
        User findByLogin = userRepository.findUserByLogin(request.getLogin()).orElse(null);
        if (findByLogin == null) {
            User user = UserMapper.addRequestToUser(request);
            user.setRegTime(LocalDateTime.now());
            userRepository.save(user);
            return UserMapper.userToAddResponse(user);
        } else {
            throw new UserAlreadyExistException("Login is already exist");
        }
    }

    public AddUserResponse updateUser(Long id, String newName) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id not found"));
        if (newName == null) {
            throw new UserUpdateParamException("need name param for update");
        }
        user.setName(newName);
        userRepository.save(user);
        return UserMapper.userToAddResponse(user);
    }

    public GetUserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id not found"));
        List<Long> topicIds = topicRepository.findIdTopicsByAuthor(user);
        return  UserMapper.userToGetUserResponse(user, topicIds);
    }
}
