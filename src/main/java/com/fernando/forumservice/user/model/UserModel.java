package com.fernando.forumservice.user.model;

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
public class UserModel {

    private String id;
    private String name;
    private String username;
    private UserRole role;
    private String password;
    private String email;
    private Boolean firstLogin;
    private List<PostTags> likedTags;
    private List<String> likedPosts;
    private List<String> posts;
}
