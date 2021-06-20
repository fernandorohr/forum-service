package com.fernando.forumservice.user.factory;

import com.fernando.forumservice.user.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserFactory {

    public UserModel updateUser(UserModel requestUser, UserModel dataBaseUser) {
        if (ObjectUtils.isEmpty(dataBaseUser)) return null;
        return UserModel.builder()
                .id(dataBaseUser.getId())
                .name(Optional.ofNullable(requestUser)
                        .map(UserModel::getName)
                        .orElse(dataBaseUser.getName()))
                .username(Optional.ofNullable(requestUser)
                        .map(UserModel::getUsername)
                        .orElse(dataBaseUser.getUsername()))
                .role(Optional.ofNullable(requestUser)
                        .map(UserModel::getRole)
                        .orElse(dataBaseUser.getRole()))
                .password(Optional.ofNullable(requestUser)
                        .map(UserModel::getPassword)
                        .orElse(dataBaseUser.getPassword()))
                .email(Optional.ofNullable(requestUser)
                        .map(UserModel::getEmail)
                        .orElse(dataBaseUser.getEmail()))
                .firstLogin(dataBaseUser.getFirstLogin())
                .likedTags(Optional.ofNullable(requestUser)
                        .map(UserModel::getLikedTags)
                        .orElse(dataBaseUser.getLikedTags()))
                .posts(Optional.ofNullable(requestUser)
                        .map(UserModel::getPosts)
                        .orElse(dataBaseUser.getPosts()))
                .likedPosts(Optional.ofNullable(requestUser)
                        .map(UserModel::getLikedPosts)
                        .orElse(dataBaseUser.getLikedPosts()))
                .build();
    }
}
