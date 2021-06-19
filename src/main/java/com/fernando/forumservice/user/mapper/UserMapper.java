package com.fernando.forumservice.user.mapper;

import com.fernando.forumservice.user.entity.UserEntity;
import com.fernando.forumservice.user.model.UserModel;
import com.fernando.forumservice.user.model.request.LoginRequest;
import com.fernando.forumservice.user.model.request.UserRequest;
import com.fernando.forumservice.user.model.response.UserResponse;

import java.util.Optional;

public class UserMapper {

    public static UserModel mapToModel (UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(user ->  UserModel.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .username(user.getUsername())
                        .role(user.getRole())
                        .password(user.getPassword())
                        .email(user.getEmail())
                        .firstLogin(user.getFirstLogin())
                        .likedTags(user.getLikedTags())
                        .posts(user.getPosts())
                        .likedPosts(user.getLikedPosts())
                        .build())
                .orElse(null);
    }

    public static UserModel mapToModel (UserRequest userRequest) {
        return Optional.ofNullable(userRequest)
                .map(user ->  UserModel.builder()
                        .name(user.getName())
                        .username(user.getUsername())
                        .role(user.getRole())
                        .password(user.getPassword())
                        .email(user.getEmail())
                        .likedTags(user.getLikedTags())
                        .posts(user.getPosts())
                        .likedPosts(user.getLikedPosts())
                        .build())
                .orElse(null);
    }

    public static UserModel mapToModel (LoginRequest loginRequest) {
        return UserModel.builder()
                .email(loginRequest.getEmail())
                .password(loginRequest.getPassword())
                .build();
    }

    public static UserEntity mapToEntity (UserModel userModel) {
        return Optional.ofNullable(userModel)
                .map(user ->  UserEntity.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .username(user.getUsername())
                        .role(user.getRole())
                        .password(user.getPassword())
                        .email(user.getEmail())
                        .firstLogin(user.getFirstLogin())
                        .likedTags(user.getLikedTags())
                        .likedPosts(user.getLikedPosts())
                        .posts(user.getPosts())
                        .build())
                .orElse(null);
    }

    public static UserResponse mapToResponse (UserModel userModel) {
        return Optional.ofNullable(userModel)
                .map(user ->  UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .username(user.getUsername())
                        .role(user.getRole())
                        .email(user.getEmail())
                        .firstLogin(user.getFirstLogin())
                        .likedTags(user.getLikedTags())
                        .likedPosts(user.getLikedPosts())
                        .posts(user.getPosts())
                        .build())
                .orElse(null);
    }
}
