package com.fernando.forumservice.user.facade;

import com.fernando.forumservice.post.model.PostModel;
import com.fernando.forumservice.user.model.UserModel;
import com.fernando.forumservice.user.model.request.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.fernando.forumservice.user.mapper.UserMapper;
import com.fernando.forumservice.user.model.request.UserRequest;
import com.fernando.forumservice.user.model.response.UserResponse;
import com.fernando.forumservice.user.service.UserService;

@Component
@AllArgsConstructor
public class UserFacade {

    private final UserService userService;

    public UserResponse create(UserRequest userRequest) {
        return UserMapper.mapToResponse(userService.create(UserMapper.mapToModel(userRequest)));
    }

    public UserResponse update(UserRequest userRequest) {
        return UserMapper.mapToResponse(userService.update(UserMapper.mapToModel(userRequest)));
    }

    public UserResponse login(LoginRequest loginRequest) {
        return UserMapper.mapToResponse(userService.login(UserMapper.mapToModel(loginRequest)));
    }

    public UserModel findByUsername(String username) {
        return userService.findByUsername(username);
    }

    public void delete(String username) {
        userService.delete(username);
    }

    public void addPost(String username, String postId) {
        userService.addPost(username, postId);
    }
}
