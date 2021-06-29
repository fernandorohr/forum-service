package com.fernando.forumservice.post.factory;

import com.fernando.forumservice.post.model.PostModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PostFactory {

    public PostModel updatePost(PostModel requestPost, PostModel databasePost) {
        if (ObjectUtils.isEmpty(databasePost)) return null;
        return PostModel.builder()
                .id(databasePost.getId())
                .author(Optional.ofNullable(requestPost)
                        .map(PostModel::getAuthor)
                        .orElse(databasePost.getAuthor()))
                .title(Optional.ofNullable(requestPost)
                        .map(PostModel::getTitle)
                        .orElse(databasePost.getTitle()))
                .body(Optional.ofNullable(requestPost)
                        .map(PostModel::getBody)
                        .orElse(databasePost.getBody()))
                .creationDate(databasePost.getCreationDate())
                .likes(Optional.ofNullable(requestPost)
                        .map(PostModel::getLikes)
                        .orElse(databasePost.getLikes()))
                .tags(Optional.ofNullable(requestPost)
                        .map(PostModel::getTags)
                        .orElse(databasePost.getTags()))
                .comments(Optional.ofNullable(requestPost)
                        .map(PostModel::getComments)
                        .orElse(databasePost.getComments()))
                .build();
    }
}
