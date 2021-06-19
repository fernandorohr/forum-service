package com.fernando.forumservice.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fernando.forumservice.post.enums.PostTags;
import com.fernando.forumservice.user.enums.UserRole;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private String name;
    private String username;
    private UserRole role;
    private String password;
    private String email;
    private List<PostTags> likedTags;
    private List<String> likedPosts;
    private List<String> posts;
}
