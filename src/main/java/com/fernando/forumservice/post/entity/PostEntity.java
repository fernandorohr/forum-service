package com.fernando.forumservice.post.entity;

import com.fernando.forumservice.post.enums.PostTags;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "posts")
public class PostEntity {

    @Id
    private String id;
    private String author;
    private String title;
    private String body;
    private LocalDateTime creationDate;
    private Integer likes;
    private List<PostTags> tags;
    private List<CommentEntity> comments;
}
