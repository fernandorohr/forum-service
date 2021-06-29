package com.fernando.forumservice.post.mapper;

import com.fernando.forumservice.post.entity.CommentEntity;
import com.fernando.forumservice.post.model.CommentModel;
import com.fernando.forumservice.post.model.request.CommentRequest;
import com.fernando.forumservice.post.model.response.CommentResponse;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public static List<CommentModel> mapFromRequestToModelList(List<CommentRequest> comments) {
        if (ObjectUtils.isEmpty(comments)) return Collections.emptyList();
        return comments.stream()
                .map(CommentMapper::mapToModel)
                .collect(Collectors.toList());
    }

    public static CommentModel mapToModel(CommentRequest comment) {
        if (ObjectUtils.isEmpty(comment)) return null;
        return CommentModel.builder()
                .author(comment.getAuthor())
                .body(comment.getBody())
                .creationDate(LocalDateTime.now())
                .build();
    }

    public static List<CommentModel> mapToModelList(List<CommentEntity> comments) {
        if (ObjectUtils.isEmpty(comments)) return Collections.emptyList();
        return comments.stream()
                .map(CommentMapper::mapToModel)
                .collect(Collectors.toList());
    }

    public static CommentModel mapToModel(CommentEntity comment) {
        if (ObjectUtils.isEmpty(comment)) return null;
        return CommentModel.builder()
                .author(comment.getAuthor())
                .body(comment.getBody())
                .creationDate(comment.getCreationDate())
                .build();
    }

    public static List<CommentEntity> mapToEntityList(List<CommentModel> comments) {
        if (ObjectUtils.isEmpty(comments)) return Collections.emptyList();
        return comments.stream()
                .map(CommentMapper::mapToEntity)
                .collect(Collectors.toList());
    }

    public static CommentEntity mapToEntity(CommentModel comment) {
        if (ObjectUtils.isEmpty(comment)) return null;
        return CommentEntity.builder()
                .author(comment.getAuthor())
                .body(comment.getBody())
                .creationDate(comment.getCreationDate())
                .build();
    }

    public static List<CommentResponse> mapToResponseList(List<CommentModel> comments){
        if (ObjectUtils.isEmpty(comments)) return Collections.emptyList();
        return comments.stream()
                .map(CommentMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public static CommentResponse mapToResponse(CommentModel comment) {
        if (ObjectUtils.isEmpty(comment)) return null;
        return CommentResponse.builder()
                .author(comment.getAuthor())
                .body(comment.getBody())
                .creationDate(comment.getCreationDate())
                .build();
    }
}
