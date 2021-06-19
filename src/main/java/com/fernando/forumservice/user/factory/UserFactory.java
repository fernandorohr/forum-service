package com.fernando.forumservice.user.factory;

import com.fernando.forumservice.post.enums.PostTags;
import com.fernando.forumservice.user.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserFactory {

    public UserModel updateUser(UserModel requestUser, UserModel dataBaseUser) {
        if (ObjectUtils.isEmpty(requestUser)) return null;
        return UserModel.builder()
                .id(Optional.ofNullable(dataBaseUser)
                        .map(UserModel::getId)
                        .orElse(null))
                .name(requestUser.getName())
                .username(requestUser.getUsername())
                .role(requestUser.getRole())
                .password(requestUser.getPassword())
                .email(requestUser.getEmail())
                .likedTags(requestUser.getLikedTags())
                .posts(requestUser.getPosts())
                .likedPosts(requestUser.getLikedPosts())
                .build();
    }
}
