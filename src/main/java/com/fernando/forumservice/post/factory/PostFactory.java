package com.fernando.forumservice.post.factory;

import com.fernando.forumservice.post.model.CommentModel;
import com.fernando.forumservice.post.model.PostModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PostFactory {

    public PostModel updatePost(PostModel requestPost, PostModel databasePost) {
        if (ObjectUtils.isEmpty(databasePost)) return requestPost;
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
                .comments(updateComments(Optional.ofNullable(requestPost)
                        .map(PostModel::getComments)
                        .orElse(Collections.emptyList()), databasePost.getComments()))
                .build();
    }

    private List<CommentModel> updateComments(List<CommentModel> commentsRequest, List<CommentModel> databaseComments) {
        if (ObjectUtils.isEmpty(databaseComments)) return commentsRequest;
        databaseComments.addAll(commentsRequest);
        return databaseComments;
    }
}
