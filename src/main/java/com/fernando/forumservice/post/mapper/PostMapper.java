package com.fernando.forumservice.post.mapper;

import com.fernando.forumservice.post.entity.PostEntity;
import com.fernando.forumservice.post.model.PostModel;
import com.fernando.forumservice.post.model.request.PostCreationRequest;
import com.fernando.forumservice.post.model.request.PostUpdateRequest;
import com.fernando.forumservice.post.model.response.PostResponse;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostModel mapToModel(PostCreationRequest post) {
        if (ObjectUtils.isEmpty(post)) return null;
        return PostModel.builder()
                .author(post.getAuthor())
                .title(post.getTitle())
                .body(post.getBody())
                .creationDate(LocalDateTime.now())
                .tags(post.getTags())
                .build();
    }

    public static PostModel mapToModel(PostUpdateRequest post) {
        if (ObjectUtils.isEmpty(post)) return null;
        return PostModel.builder()
                .id(post.getId())
                .author(post.getAuthor())
                .title(post.getTitle())
                .body(post.getBody())
                .likes(post.getLikes())
                .tags(post.getTags())
                .comments(CommentMapper.mapFromRequestToModelList(post.getComments()))
                .build();
    }

    public static List<PostModel> mapToModelList(List<PostEntity> posts) {
        if (ObjectUtils.isEmpty(posts)) return Collections.emptyList();
        return posts.stream()
                .map(PostMapper::mapToModel)
                .collect(Collectors.toList());
    }

    public static PostModel mapToModel(PostEntity post) {
        if (ObjectUtils.isEmpty(post)) return null;
        return PostModel.builder()
                .id(post.getId())
                .author(post.getAuthor())
                .title(post.getTitle())
                .body(post.getBody())
                .creationDate(post.getCreationDate())
                .likes(post.getLikes())
                .tags(post.getTags())
                .comments(CommentMapper.mapToModelList(post.getComments()))
                .build();
    }

    public static PostEntity mapToEntity(PostModel post) {
        return Optional.ofNullable(post)
                .map(postModel -> PostEntity.builder()
                        .id(postModel.getId())
                        .author(postModel.getAuthor())
                        .title(postModel.getTitle())
                        .body(postModel.getBody())
                        .creationDate(postModel.getCreationDate())
                        .tags(postModel.getTags())
                        .likes(postModel.getLikes())
                        .comments(CommentMapper.mapToEntityList(postModel.getComments()))
                        .build())
                .orElse(null);
    }

    public static List<PostResponse> mapToResponselList(List<PostModel> posts) {
        if (ObjectUtils.isEmpty(posts)) return Collections.emptyList();
        return posts.stream()
                .map(PostMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public static PostResponse mapToResponse(PostModel post) {
        if (ObjectUtils.isEmpty(post)) return null;
        return PostResponse.builder()
                .id(post.getId())
                .author(post.getAuthor())
                .title(post.getTitle())
                .body(post.getBody())
                .creationDate(post.getCreationDate())
                .likes(post.getLikes())
                .tags(post.getTags())
                .comments(CommentMapper.mapToResponseList(post.getComments()))
                .build();
    }
}
