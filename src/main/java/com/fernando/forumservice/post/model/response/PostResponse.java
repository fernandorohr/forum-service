package com.fernando.forumservice.post.model.response;

import com.fernando.forumservice.post.enums.PostTags;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {

    private String id;
    private String author;
    private String title;
    private String body;
    private LocalDateTime creationDate;
    private Long likes;
    private List<PostTags> tags;
    private List<CommentResponse> comments;
}
