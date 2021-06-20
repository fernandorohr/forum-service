package com.fernando.forumservice.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentEntity {

    private String author;
    private String body;
    private LocalDateTime creationDate;
}
